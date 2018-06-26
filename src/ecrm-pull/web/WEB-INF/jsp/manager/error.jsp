<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Error</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <style type="text/css">
        html{
            -webkit-font-smoothing: antialiased;
            text-rendering: optimizeLegibility;
        }
        html,
        body,
        .four_oh_four {
            padding: 0px;
            margin: 0px;
            height: 100%;
            width: 100%;
        }
        .four_oh_four {
            background-image: -o-linear-gradient(-38deg, #1AB5C2 0%, #0572E0 100%);
            background-image: -moz-linear-gradient(-38deg, #1AB5C2 0%, #0572E0 100%);
            background-image: -ms-linear-gradient(-38deg, #1AB5C2 0%, #0572E0 100%);
            background-image: linear-gradient(128deg, #1AB5C2 0%, #0572E0 100%);
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            color: #fff;
        }
        .four_oh_four .logo {
            display: block;
            margin: 0 auto;
            top: 50px;
            position: relative;
        }
        .four_oh_four .nav {
            list-style: none;
            font-weight: 200;
            font-size: 18px;
            margin: 0 auto;
            position: absolute;
            padding: 0;
            bottom: 50px;
            width: 100%;
            text-align: center;
        }
        .four_oh_four .nav li {
            display: inline-block;
            margin: 0px 10px;
        }
        .four_oh_four .nav a {
            color: #fff;
            text-decoration: none;
        }
        .four_oh_four .nav a:hover {
            text-decoration: underline;
        }
        .four_oh_four .error {
            display: block;
            position: absolute;
            top: 50%;
            -moz-transform: translateY(-50%);
            -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
            margin: 0;
            padding: 0;
            text-align: center;
            width: 100%;
        }
        .four_oh_four h1 {
            font-weight: 100;
            font-size: 240px;
            margin: 0;
            padding: 0;
        }
        .four_oh_four h2 {
            font-weight: 200;
            font-size: 28px;
            margin: 0;
            padding: 0;
        }
        .four_oh_four #emoji {
            position: relative;
            top: 40px;
            background-image: url('${pageContext.request.contextPath }/resource/images/sprite.png');
            display: inline-block;
            width: 200px;
            height: 230px;
            background-size: 6000px;
            background-repeat: no-repeat;
        }
        @media (max-width: 500px) {
            .four_oh_four .logo {
                top: 30px;
            }
            .four_oh_four h1 {
                font-size: 120px;
            }
            .four_oh_four h2 {
                font-size: 22px;
            }
            .four_oh_four #emoji {
                width: 100px;
                height: 115px;
                top: 16px;
                background-size: 3000px;
            }
            .four_oh_four .nav {
                bottom: 30px;
            }
            .four_oh_four .nav li {
                margin: 5px 14px;
            }
        }
    </style>
    <script>
        var emojiCount = 30;
        function getRandomInt(min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }


        function catchFeelings() {
            var emoji = getRandomInt(0, emojiCount - 1)
            if(window.innerWidth > 400){
                var bgOffset = (emoji * 200 * -1) + "px 0px"
            } else {
                var bgOffset = (emoji * 100 * -1) + "px 0px"
            }
            document.getElementById('emoji').style.backgroundPosition = bgOffset;
        }
    </script>
</head>

<body>

    <div class="four_oh_four">
        <figure class="error">
            <h1>Err<div id="emoji"></div>r</h1>
             <h2>${msg }</h2>
        </figure>       
    </div>

</body>
<script>
    catchFeelings();

    setTimeout(function () {
        setInterval(function () {
            catchFeelings()
        }, 3000)
    }, 3000)

    document.addEventListener('keydown', function(e) {
        e = e || window.event;
        switch (e.which || e.keyCode) {
        case 32:
            for (var i = 0; i < 20; i++) {
                setTimeout(function () {
                    catchFeelings();
                }, 50 * i)
            }
            break;

        default:
            return;
        }
        e.preventDefault();
    });
</script>

</html>
