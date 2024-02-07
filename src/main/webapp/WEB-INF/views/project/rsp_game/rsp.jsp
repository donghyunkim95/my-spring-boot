<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/rsp_game/style.css" />
    <title>Rock & Scissors & Paper</title>
</head>
<body>
<div id="form">
    <img src="/rsp_game/rock.png" alt="rock">
    <img src="/rsp_game/scissors.png" alt="scissors">
    <img src="/rsp_game/paper.png" alt="paper">
</div>
<hr/>
<hr/>
<ul>
    <li>Win count : 1</li>
    <li>Lose count : 2</li>
    <li>Draw count : 3</li>
</ul>
<hr/>
<hr/>
<div id="result">
    <div id="you">

    </div>
    <div id="computer" class="winner">
        <img src="/rsp_game/rock.png">
        Computer
    </div>
</div>

<script src="/rsp_game/script.js"></script>
</body>
</html>