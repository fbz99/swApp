$(document).ready(function() {

    try{
        $.get({
            url: 'http://swapp-be.mastercc.hpc4ai.unito.it/annunci/myads',
            type: "GET", /* or type:"GET" or type:"PUT" */
            contentType: 'application/json',
            headers: {
                Authorization: Cookies.get('auth'),
               // username: Cookies.get('username')
            },
            success: function (data, textStatus, request) {
                let mainbody = $("#mainbody");
                let exchange = $("#exchanged");
                printAds(data, mainbody, exchange);
                let modal = $("#mymodal");
                $('.card-title').click(function() {

                    let name = $(this).attr("name");
                    let splitted = name.split(";");
                    let id = splitted[1];
                    let liked = splitted[2];
                    let currId = id;
                    if (liked == 1)$("#relatedsection").hide();
                    else $("#relatedsection").show();
                    updateModal(splitted, modal, data)
                    /*$('#heart').click(function() {
                        $('#heart').addClass("heartclicked")
                    });*/
                    //console.log(data);
                    $.get({
                        url: 'http://swapp-be.mastercc.hpc4ai.unito.it/annuncio/' + id,
                        type: "GET", /* or type:"GET" or type:"PUT" */
                        contentType: 'application/json',
                        headers: {
                            Authorization: Cookies.get('auth'),
                            //username: Cookies.get('username')
                        },
                        success: function (data, textStatus, request) {
                            let related = $("#related");
                            let liked = $("#liked");
                            related.html("");
                            liked.html("");
                            console.log(data)
                            related.append(printRelatedAds(data.vectorD));
                            liked.append(printRelatedAds(data.vectorL));

                            $("#relatedsection").on("click", "#relatedtitle", function() {
                                let name = $(this).attr("name");
                                let splitted = name.split(";");
                                let id = splitted[1];
                                console.log(currId + " - " + id)
                                updateModal(splitted, modal, data.vectorD)
                            });
                            $("#relatedsection").on("click", "#relatedlike", function() {
                                let element = $(this);
                                let name = $(this).attr("name");
                                let splitted = name.split(";");
                                let id = splitted[1];
                                console.log(currId + " - " + id)
                                swal({
                                    title: "Sei sicuro di voler mettere like?",
                                    text: "Non potrai tornare indietro!",
                                    icon: "warning",
                                    buttons: true,
                                    dangerMode: true,
                                })
                                    .then((willDelete) => {
                                        if (willDelete) {
                                            likeItem(currId, id)
                                            if(element.hasClass("btn-outline-danger")){
                                                element.addClass("btn-danger disabled");
                                                element.removeClass("btn-outline-danger");
                                            }

                                        } else {
                                            swal("Sei salvo, per ora");
                                        }
                                    });
                                //updateModal(splitted, modal, data.vectorD)
                            });
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            console.log(xhr.statusText);
                            swal("Attenzione!", "Controlla le informazioni e riprova!", "error");
                        }
                    });

                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.statusText);
                swal("Attenzione!", "Controlla le informazioni e riprova!", "error");
            }
        });
    }catch(error){
        console.log(error.message);
    }

});

$("#logoutBtn").click(function(){
    Cookies.remove();
    location.replace('index.html');
});

$("#openModalButton").click(function() {
    $('#myModal').modal('show');
});
$("#closeModalButton").click(function() {
    $('#myModal').modal('hide');
});

$("#closeModal").click(function() {
    $('#myModal').modal('hide');
});
