             var post= document.getElementById("post");
             post.addEventListener("click", function()
             {
            var commentBoxValue= document.getElementById("comment-box").value;
            var li = document.createElement("li");
            var text = document.createTextNode(commentBoxValue);
            li.appendChild(text);
            document.getElementById("unordered").appendChild(li);

              });

              $.ajax({
            type : "POST",
                url : '/bin/submitdata',
                /*data : {
                pass your request parameter here, currently we are not passing any data
                },*/
                success : function(data, textStatus, jqXHR) {
                //write your logic that you need to perform on sucess
                console.log("Success!!!!");
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                //write your logic that you need to perform on error
                        console.log("Failed!!");

                }
                });