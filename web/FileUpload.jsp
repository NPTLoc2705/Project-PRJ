<%-- 
    Document   : FileUpload
    Created on : Jun 14, 2024, 10:10:14 AM
    Author     : Tab135
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"
        />
        <link rel="stylesheet" href="CSS/bootstrap.min.css" />
        <link rel="stylesheet" href="CSS/templatemo-style.css" />
        <link rel="stylesheet" href="CSS/Upload.css"/>
        <title>File Upload</title>
        
        <style>
            .upload-box {
                max-width: 600px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                background-color: #fff;
            }
            .upload-icon {
                font-size: 50px;
                color: #007bff;
                text-align: center;
                margin-bottom: 20px;
            }
            .input-group {
                margin-bottom: 15px;
            }
            .file-label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }
            .file-input {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            .text-input, .textarea-input {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                margin-bottom: 10px;
            }
            .textarea-input {
                height: 100px;
                resize: vertical;
            }
            .upload-button {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                border: none;
                border-radius: 5px;
                color: #fff;
                font-size: 16px;
                cursor: pointer;
            }
            .upload-button:hover {
                background-color: #0056b3;
            }
            h2 {
                text-align: center;
                margin-bottom: 20px;
                font-weight: bold;
                color: #333;
            }
            .input-group label {
                display: inline-block;
                margin-right: 10px;
            }
            .input-group input[type="checkbox"] {
                margin-right: 5px;
            }
            .genres-container {
                display: flex;
                flex-wrap: wrap;
            }
            .genres-container div {
                flex: 1 1 14.28%; /* Seven columns */
                margin-bottom: 10px;
                box-sizing: border-box;
            }
        </style>
    </head>
    <body>
        <%@ include file="/nav.jsp" %>
        <div class="container">
            <div class="upload-box">
                <div class="upload-icon">
                    <i class="fas fa-upload"></i>
                </div>
                <h2>Upload your book</h2>
                <form action="Upload?userID=${sessionScope.loginSession.userID}" method="POST" enctype="multipart/form-data">
                    <div class="input-group">
                        <label for="file-upload" class="file-label">Choose file</label>
                        <input type="file" id="file-upload" class="file-input" name="file">
                        <span id="file-chosen">No file chosen</span>
                    </div>

                    <div class="input-group">
                        <label for="cover-upload" class="file-label">Choose file</label>
                        <input type="file" id="cover-upload" class="file-input" name="cover-image">
                        <span id="file-chosen2">No file chosen</span>
                    </div>
                    
                    <div class="input-group">
                        <label for="genres">Choose a book genre(s):</label>
                        <div class="genres-container">
                            <div><input type="checkbox" id="horror" name="genres" value="Horror"><label for="horror">Horror</label></div>
                            <div><input type="checkbox" id="romance" name="genres" value="Romance"><label for="romance">Romance</label></div>
                            <div><input type="checkbox" id="dark-fantasy" name="genres" value="Dark-Fantasy"><label for="dark-fantasy">Dark Fantasy</label></div>
                            <div><input type="checkbox" id="science-fiction" name="genres" value="Science-Fiction"><label for="science-fiction">Science Fiction</label></div>
                            <div><input type="checkbox" id="mystery" name="genres" value="Mystery"><label for="mystery">Mystery</label></div>
                            <div><input type="checkbox" id="thriller" name="genres" value="Thriller"><label for="thriller">Thriller</label></div>
                            <div><input type="checkbox" id="fantasy" name="genres" value="Fantasy"><label for="fantasy">Fantasy</label></div>
                            <div><input type="checkbox" id="adventure" name="genres" value="Adventure"><label for="adventure">Adventure</label></div>
                            <div><input type="checkbox" id="non-fiction" name="genres" value="Non-Fiction"><label for="non-fiction">Non-Fiction</label></div>
                            <div><input type="checkbox" id="historical-fiction" name="genres" value="Historical-Fiction"><label for="historical-fiction">Historical Fiction</label></div>
                        </div>
                    </div>
                    
                    <div class="text-fields">
                        <input type="text" placeholder="Author" class="text-input" name="author">
                        <input type="text" placeholder="Book name" class="text-input" name="bookname">
                    </div>
                    <div class="description-field">
                        <textarea placeholder="Description" class="textarea-input" name="description"></textarea>
                    </div>
                    <% String error = (String) request.getAttribute("error");
                       String success = (String) request.getAttribute("success");
                       if (error != null) {%>
                        <h3 style="color: red"><%= error %></h3>
                    <% } %>
                    <% if (success != null) { %>
                        <h3 style="color: lime"><%= success %></h3>
                    <% } %>
                    <button type="submit" class="upload-button">Upload</button>
                </form>
            </div>
        </div>
    </body>

    <script>
        const actualBtn = document.getElementById('file-upload');
        const BtnImage = document.getElementById('cover-upload');
        const fileChosen = document.getElementById('file-chosen');
        const fileChosen2 = document.getElementById('file-chosen2');
        actualBtn.addEventListener('change', function () {
            fileChosen.textContent = this.files[0].name;
        });
        BtnImage.addEventListener('change', function () {
            fileChosen2.textContent = this.files[0].name;
        });
    </script>
</html>
