package platform.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.database.CodeRepository;
import platform.elements.Code;
import platform.elements.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class CodeController {

    final
    CodeRepository codeRepository;

    public CodeController(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @GetMapping("/code/{id}")
    public String getStringCode(@PathVariable String id, HttpServletResponse response,
                                ModelMap modelMap) {
        response.addHeader("Content-Type", "text/html");

        Optional<Code> code = codeRepository.findById(id);
        Code trueCode = code.orElseThrow();

        if ((trueCode.getTime() <= 0 && trueCode.isTimeRestrict()) ||
                (trueCode.getViews() <= 0 && trueCode.isViewRestrict())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            trueCode.increaseTimeViewed();

            codeRepository.save(trueCode);

            modelMap.addAttribute("date", trueCode.getFormattedDate());
            modelMap.addAttribute("code", trueCode.getCode());
            modelMap.addAttribute("views", trueCode.getViews());
            modelMap.addAttribute("time", trueCode.getTime());
            modelMap.addAttribute("timeRestrict", trueCode.isTimeRestrict());
            modelMap.addAttribute("viewRestrict", trueCode.isViewRestrict());

            return "code_display";
        }
    }

    @GetMapping("/api/code/{id}")
    public ResponseEntity<Code> getJsonCode(@PathVariable String id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        Optional<Code> code = codeRepository.findById(id);
        Code trueCode = code.orElseThrow();

        if ((trueCode.getTime() <= 0 && trueCode.isTimeRestrict()) ||
                (trueCode.getViews() <= 0 && trueCode.isViewRestrict())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            trueCode.increaseTimeViewed();

            codeRepository.save(trueCode);

            return ResponseEntity.ok()
                    .headers(httpHeaders)
                    .body(trueCode);
        }

    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    public ResponseEntity<Result> postJsonCode(@RequestBody Code newCode) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        newCode.setRestricts();

        codeRepository.save(newCode);

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(new Result(newCode.getId()));
    }

    @GetMapping("/code/new")
    public String postStingCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");

        return "code_new";
    }

    @GetMapping("/api/code/latest")
    public ResponseEntity<List<Code>> getLatestJsonCode() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        List<Code> latestCode = codeRepository
                .findTop10ByTimeRestrictAndViewRestrictOrderByDateDescIdDesc(false, false);

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(latestCode);
    }

    @GetMapping("/code/latest")
    public String getLatestStringCode(HttpServletResponse response, ModelMap modelMap) {
        response.addHeader("Content-Type", "text/html");

        List<Code> latestCode = codeRepository
                .findTop10ByTimeRestrictAndViewRestrictOrderByDateDescIdDesc(false, false);

        modelMap.addAttribute("latestCode", latestCode);

        return "code_latest";
    }

}
