<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <link rel="stylesheet" href="../static/css/code.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <span id="load_date">${date}</span>
    <br>
    <#if viewRestrict>
    <span id="views_restriction">${views} more views allowed</span>
    <br>
    </#if>
    <#if timeRestrict>
    <span id="time_restriction">The code will be available for ${time} seconds</span>
    <br>
    </#if>
    <pre id="code_snippet"><code>${code}</code></pre>
</body>
</html>