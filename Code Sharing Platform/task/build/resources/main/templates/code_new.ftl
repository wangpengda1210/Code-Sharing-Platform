<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <script type="text/javascript" src="../static/js/send_button.js"></script>
    <link rel="stylesheet" href="../static/css/code.css">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <textarea id="code_snippet">// write your code here</textarea>
    <br>
    <label for="time_restriction">Time restriction:</label>
    <input id="time_restriction" type="number">
    <br>
    <label for="views_restriction">Views restriction:</label>
    <input id="views_restriction" type="number">
    <br>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</body>
</html>