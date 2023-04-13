function printAds(data, mainbody, exchange){
    console.log(data);
    var mainresult = "<div class=\"row\">";
    var excresult = "<div class=\"row\">";
    if (data != null && data.length != 0) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i].exchange_id);
            if (i % 3 == 0) {
                if(data[i].exchange_id == null) {
                    mainresult += "<div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                        "        <div class=\"card\">\n" +
                        "          <div class=\"bg-image hover-zoom ripple ripple-surface ripple-surface-light\"\n" +
                        "               data-mdb-ripple-color=\"light\">\n" +
                        "            <img src=" + data[i].image +
                        "                 class=\"w-100\" />\n" +
                        "            <a href=\"#!\">\n" +
                        "            </a>\n" +
                        "          </div>\n" +
                        "          <div class=\"card-body\">\n" +
                        "            <a  class=\"text-reset text-decoration-none\">\n" +
                        "              <h5 name = " + i + ";" + data[i].id + ";" +"0" +  " class=\"card-title mb-3\"  >" + data[i].titolo + "</h5>\n" +
                        "            </a>\n" +
                        "            <a class=\"text-reset text-decoration-none\">\n" +
                        "              <p>" + data[i].categorie + "</p>\n" +
                        "            </a>\n" +
                        "          </div>\n" +
                        "        </div>\n" +
                        "      </div>"
                } else excresult += "<div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                    "        <div class=\"card\">\n" +
                    "          <div class=\"bg-image hover-zoom ripple ripple-surface ripple-surface-light\"\n" +
                    "               data-mdb-ripple-color=\"light\">\n" +
                    "            <img src=" + data[i].image +
                    "                 class=\"w-100\" />\n" +
                    "            <a href=\"#!\">\n" +
                    "            </a>\n" +
                    "          </div>\n" +
                    "          <div class=\"card-body\">\n" +
                    "            <a  class=\"text-reset text-decoration-none\">\n" +
                    "              <h5 name = " + i + ";" + data[i].id + ";" +"1" +  " class=\"card-title mb-3\"  >" + data[i].titolo + "</h5>\n" +
                    "            </a>\n" +
                    "            <a class=\"text-reset text-decoration-none\">\n" +
                    "              <p>" + data[i].categorie + "</p>\n" +
                    "            </a>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>"
                //mainbody.append("<div class=\"row\">");
            } else if (i % 3 != 0) {
                if(data[i].exchange_id == null)
                    mainresult += "<div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                    "        <div class=\"card\">\n" +
                    "          <div class=\"bg-image hover-zoom ripple ripple-surface ripple-surface-light\"\n" +
                    "               data-mdb-ripple-color=\"light\">\n" +
                    "            <img src=" + data[i].image + " id = " + data[i].id +
                    "                 class=\"w-100\" />\n" +
                    "            <a>\n" +
                    "            </a>\n" +
                    "          </div>\n" +
                    "          <div class=\"card-body\">\n" +
                    "            <a class=\"text-reset text-decoration-none\">\n" +
                    "              <h5 name = " + i + ";" + data[i].id + ";" +"0" + " class=\"card-title mb-3\"  >" + data[i].titolo + "</h5>\n" +
                    "            </a>\n" +
                    "            <a href=\"\" class=\"text-reset text-decoration-none\">\n" +
                    "              <p>" + data[i].categorie + "</p>\n" +
                    "            </a>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>";
                else excresult += "<div class=\"col-lg-4 col-md-6 mb-4\">\n" +
                    "        <div class=\"card\">\n" +
                    "          <div class=\"bg-image hover-zoom ripple ripple-surface ripple-surface-light\"\n" +
                    "               data-mdb-ripple-color=\"light\">\n" +
                    "            <img src=" + data[i].image + " id = " + data[i].id +
                    "                 class=\"w-100\" />\n" +
                    "            <a>\n" +
                    "            </a>\n" +
                    "          </div>\n" +
                    "          <div class=\"card-body\">\n" +
                    "            <a class=\"text-reset text-decoration-none\">\n" +
                    "              <h5 name = " + i + ";" + data[i].id + ";" +"1" +  " class=\"card-title mb-3\"  >" + data[i].titolo + "</h5>\n" +
                    "            </a>\n" +
                    "            <a href=\"\" class=\"text-reset text-decoration-none\">\n" +
                    "              <p>" + data[i].categorie + "</p>\n" +
                    "            </a>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>";
            }
        }
        mainbody.append(mainresult);
        if(exchange!=undefined)exchange.append(excresult);
    }
}


function printRelatedAds(data) {
    var result = "";
    let classbtn = ""
    if (data != null && data.length != 0) {
        for (let i = 0; i < data.length; i++) {
            if(data[i].liked == true) classbtn = "btn-danger disabled\" ";
            else classbtn = "btn-outline-danger\"";
            if (i % 3 == 0) {
                if (i == 0) result += "<div  class=\"row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center\">"
                else result += "</div><div  class=\"row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center\">"
                result += "<div class=\"col mb-5\">\n" +
                    "                <div class=\"card h-100\">\n" +
                    "                    <!-- Product image-->\n" +
                    "                    <img class=\"card-img-top\" id=\"relatedtitle\" name=" + i + ";" + data[i].id + " src=\"" + data[i].image + "\"/>" +
                    "                    <div class=\"card-body p-4\">\n" +
                    "                        <div class=\"text-center\">\n" +
                    "                            <h5 id=\"relatedtitle\" class=\"fw-bolder\" name=" + i + ";" + data[i].id + ">" + data[i].titolo + "</h5>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">\n" +
                    "                        <div class=\"text-center\"><a id=\"relatedlike\" name=" + i + ";" + data[i].id + "  class=\"btn mt-auto " + classbtn +">Like</a></div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>"

                //mainbody.append("<div class=\"row\">");
            } else if (i % 3 != 0) {
                result += "<div class=\"col mb-5\">\n" +
                    "                <div class=\"card h-100\">\n" +
                    "                    <!-- Product image-->\n" +
                    "                    <img class=\"card-img-top\" id=\"relatedtitle\" name=" + i + ";" + data[i].id + " src=\"" + data[i].image + "\"/>" +
                    "                    <!-- Product details-->\n" +
                    "                    <div class=\"card-body p-4\">\n" +
                    "                        <div class=\"text-center\">\n" +
                    "                            <!-- Product name-->\n" +
                    "                            <h5 id=\"relatedtitle\" name=" + i + ";" + data[i].id + " class=\"fw-bolder\">" + data[i].titolo + "</h5>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <!-- Product actions-->\n" +
                    "                    <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">\n" +
                    "                        <div class=\"text-center\"><a id=\"relatedlike\" name=" + i + ";" + data[i].id + "  class=\"btn mt-auto " + classbtn +">Like</a></div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>";
            }
        }

    } else result += ""
    return result;
}

function likeItem(myItem, targetItem){
    try{
        $.post({
            url: 'http://swapp-be.mastercc.hpc4ai.unito.it/annunci/ad/'+ myItem + "/like",
            type: "POST", /* or type:"GET" or type:"PUT" */
            contentType: 'application/json',
            headers: {
                Authorization: Cookies.get('auth')
            },
            data: targetItem,
            success: function (data, textStatus, request) {
                swal("Perfetto!", "Like aggiunto con successo!", "success")
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.statusText);
                swal("Attenzione!", "Qualcosa è andato storto!", "error");
            }
        });
    }catch(error){
        console.log(error.message);
    }
}

function updateModal(splitted, modal, element){
    var index = splitted[0];
    $('#modal-title').html(element[index].titolo);
    $('#modal-description').html(element[index].descrizione);
    let res = "";
    let elem = element[index].categorie;
    for (let i = 0; i < elem.length; i++) {
        if(i == 0)res += element[index].categorie[i];
        else res += " - " + element[index].categorie[i];
    }
    $('#modal-categories').html(res);
    $("#image-modal").attr("src",element[index].image);
    $('#myModal').modal('show');
}
