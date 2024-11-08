<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap"
            rel="stylesheet"
    />
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }
        body{
            min-height: 100vh;
            width: 100%;
        }
        .container{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            max-width: 430px;
            width: 100%;
            background: #fff;
            border-radius: 7px;
            box-shadow: 0 5px 10px rgba(0,0,0,0.3);
        }
        .container .form{
            padding: 2rem;
        }
        .form header{
            font-size: 2rem;
            font-weight: 500;
            text-align: center;
            margin-bottom: 1.5rem;
        }
        .form input{
            height: 60px;
            width: 100%;
            padding: 0 15px;
            font-size: 17px;
            margin-bottom: 1.3rem;
            border: 1px solid #ddd;
            border-radius: 6px;
            outline: none;
        }
        .form input:focus{
            box-shadow: 0 1px 0 rgba(0,0,0,0.2);
        }
        .form a{
            font-size: 16px;
            color: #009579;
            text-decoration: none;
        }
        .form a:hover{
            text-decoration: underline;
        }
        .form input.button{
            color: #fff;
            background: #009579;
            font-size: 1.2rem;
            font-weight: 500;
            letter-spacing: 1px;
            margin-top: 1.7rem;
            cursor: pointer;
            transition: 0.4s;
        }
        .form input.button:hover{
            background: #006653;
        }
    </style>

    <script>
        function sendData() {
            const data = {
                username: document.querySelector('input[name="username"]').value,
                password: document.querySelector('input[name="password"]').value
            }

            fetch(
                '/registration', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                }
            )
                .then(response =>{
                    response.json();
                    if(response.ok) {
                        window.location.href='/login';
                    }
                }
                )
                .then(res => console.log(res))
                .catch(error => console.log(error));
        }

    </script>

    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="registration form">
            <header >Реєстрація</header>
            <form onsubmit="sendData(); return false">
                <input type="text" name="username" placeholder="Створити логін">
                <input type="password" name="password" placeholder="Створити пароль">
                <input type="submit" class="button" value="Зареєструватися">
            </form>
        </div>
    </div>
</body>
</html>