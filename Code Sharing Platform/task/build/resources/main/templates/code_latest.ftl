<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link rel="stylesheet" href="../static/css/code.css">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <link rel="stylesheet" href="../static/css/code.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <#list latestCode as code>
        <span id="load_date">${code.getFormattedDate()}</span>
        <pre id="code_snippet"><code>${code.code}</code></pre>
    </#list>
</body>
</html>