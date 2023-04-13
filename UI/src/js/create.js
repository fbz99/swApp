$( document ).ready(function() {
    let base64 = "";
    id = window.location.search.split("=")[1]
    console.log(Cookies.get('username'))
    if(Cookies.get('auth') == undefined){
        location.replace('index.html');
    }else{;
        console.log(Cookies.get('auth'))
    }

    $("#foto").on("change", function() {
        const input = this;
        const file = input.files[0];
        const reader = new FileReader();
        reader.onload = function(event) {
            var b64 = event.target.result;
            console.log(b64);
            base64 = b64;
        };
        reader.readAsDataURL(file);
    });


       $("#confirmBtn").click(function() {
           var checkboxes = document.getElementsByName('categories');
           var stato = $("input[name='optradio']:checked").val();
           var title= $("#titolo").val();
           //var foto= $("#foto");
           //console.log(foto);
           var description= $("#description").val();
           var categories = Array();
           var strCat = "[";
           for (var i = 0; i < checkboxes.length; i++) {
               if (checkboxes[i].checked) {
                   //checkboxes[i].
                   categories.push(checkboxes[i].value);
               }
           }

           console.log("title: " + title + " - foto: " + base64 + " - description: " + description + " - categories: " + categories + " - stato: " + stato);
           //console.log(categories);
           if(!window.location.search.split("=")[1]){
           console.log("id assente")
           try{
               $.post({
                   url: 'http://swapp-be.mastercc.hpc4ai.unito.it/annunci/ad',
                   type: "POST", /* or type:"GET" or type:"PUT" */
                   contentType: 'application/json',
                   headers: {
                       Authorization: Cookies.get('auth')
                   },
                   data: JSON.stringify({"titolo": title, "descrizione": description, "categorie": categories, "stato": stato, "image": base64}),
                   success: function (data, textStatus, request) {
                       swal("Perfetto!", "L'articolo e' stato aggiunto con successo!", "success")
                   },
                   error: function (xhr, ajaxOptions, thrownError) {
                       console.log(xhr.statusText);
                       swal("Attenzione!", "Controlla le informazioni e riprova!", "error");
                   }
               });
           }catch(error){
               console.log(error.message);
           }
           }
           else{
                   try{
                       $.post({
                           url: 'http://swapp-be.mastercc.hpc4ai.unito.it/annunci/ad/'+id,
                           type: "POST", /* or type:"GET" or type:"PUT" */
                           contentType: 'application/json',
                           headers: {
                               Authorization: Cookies.get('auth')
                           },
                           data: JSON.stringify({"titolo": title, "descrizione": description, "categorie": categories, "stato": stato, "image": base64}),
                           success: function (data, textStatus, request) {
                               swal("Perfetto!", "L'articolo e' stato aggiunto con successo!", "success")
                           },
                           error: function (xhr, ajaxOptions, thrownError) {
                               console.log(xhr.statusText);
                               swal("Attenzione!", "Controlla le informazioni e riprova!", "error");
                           }
                       });
                   }catch(error){
                       console.log(error.message);
                   }
           }
           console.log(categories);
       });

    $("#logoutBtn").click(function(){
        Cookies.remove();
        location.replace('index.html');
    });
});


