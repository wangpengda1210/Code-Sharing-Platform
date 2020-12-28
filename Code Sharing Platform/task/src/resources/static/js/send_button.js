function send() {
    let time = 0;
    if (document.getElementById("time_restriction").value !== "") {
        time = parseInt(document.getElementById("time_restriction").value)
    }
    if (time < 0) {
        time = 0;
    }

    let views = 0;
    if (document.getElementById("views_restriction").value !== "") {
        views = parseInt(document.getElementById("views_restriction").value)
    }
    if (views < 0) {
        views = 0;
    }

    let object = {
        "code": document.getElementById("code_snippet").value,
        "time": time,
        "views": views
    };

    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/code/new', false);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    if (xhr.status === 200) {
        alert("Success!");
    }
}