package platform.database;

import org.springframework.data.repository.CrudRepository;
import platform.elements.Code;

import java.util.List;

public interface CodeRepository extends CrudRepository<Code, String> {

    List<Code> findTop10ByTimeRestrictAndViewRestrictOrderByDateDescIdDesc(boolean timeRestrict, boolean viewRestrict);

}
