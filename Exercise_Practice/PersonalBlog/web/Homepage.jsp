<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Simple Blog</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #eaeaea;
                color: #333;
            }

            header {
                background-color: #333;
                color: #fff;
                text-align: center;
                padding: 1em;
            }

            nav {
                background-color: #444;
                color: #fff;
                text-align: right;
                padding: 0.5em;
            }

            nav form {
                display: inline-block;
                margin-right: 10px;
            }

            form input[type="text"],
            form input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            form input[type="submit"] {
                background-color: white;
                color: black;
                padding: 12px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;
                display: inline-block;
            }

            form input[type="submit"]:hover {
                background-color: aliceblue;
            }

            section {
                padding: 20px;
                display: flex;
                flex-wrap: wrap;
                justify-content: space-around;
            }

            .post {
                display: flex;
                /* Set display property to flex */
                margin: 10px;
                padding: 10px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            }

            .post img {
                width: 120px;
                /* Fixed size for square image */
                height: 120px;
                border-radius: 5px;
                margin-right: 10px;
                /* Spacing between image and content */
            }

            .post-content {
                flex: 1;
                /* Make content take up the remaining space */
            }

            .post-content a {
                text-decoration: none;
                /* Hide underline for links in post content */
                color: #333;
                /* Link text color */
            }
        </style>
    </head>

    <body>

        <header>
            <h1>Ngo Ba Hoang Quan's Blog</h1>
        </header>

        <nav>
            <form action="Login" method="get">
                <input type="submit" value="Login">
            </form>
            <form action="Login" method="get">
                <input type="submit" value="Signup">
            </form>
            <form action="Login" method="get">
                <input type="submit" value="Write a Post">
            </form>
        </nav>

        <section>
            <!-- Display blog posts here -->
            <div class="post">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/Static/tree-736885_1280.jpg" alt="nan"/>
                    <div class="post-content">
                        <a href="#">
                            <h3>Post Title 1</h3>
                        </a>
                        <p>Author: John Doe</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed
                            cursus ante dapibus diam.</p>
                    </div>
                </a>
            </div>

            <div class="post">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/Static/tree-736885_1280.jpg" alt="nan"/>
                    <div class="post-content">
                        <a href="#">
                            <h3>Post Title 1</h3>
                        </a>
                        <p>Author: John Doe</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed
                            cursus ante dapibus diam.</p>
                    </div>
                </a>
            </div>
        </section>

    </body>

</html>
