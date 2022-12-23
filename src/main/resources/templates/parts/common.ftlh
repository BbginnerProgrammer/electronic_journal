<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Electronic Journal</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src='https://www.google.com/recaptcha/api.js'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
                // Add Class
                $('.edit').click(function(){
                    $(this).addClass('editMode');
                });
                // Save data
                $(".edit").focusout(function(){
                    $(this).removeClass("editMode");
                    let id = this.id;
                    let split_id = id.split(":");
                    let field_name = split_id[0];
                    let edit_id = split_id[1];
                    let value = $(this).text();
                    let result = parseInt(value);
                    console.log(field_name);
                    console.log(edit_id);
                    console.log(value);
                    if (result >= 2 && result <= 5) {
                        $.get("http://localhost:8080/testget?name=" + field_name + "_" + edit_id + "_" + value, function (data, status) {
                            $("#divId1").html(data);
                        });
                    }
                });
            });
        </script>

    </head>
    <body>
    <#include "navbar.ftlh">
    <div class="container mt-5">
        <#nested>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

    </body>
    </html>
</#macro>