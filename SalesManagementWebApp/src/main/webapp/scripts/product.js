/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    function handleDel(id) {
        var r = confirm(`Are you sure to delete this product! `);
        if (r == true) {
            var xhttp = new XMLHttpRequest() || ActiveXObject();
                xhttp.onreadystatechange = function () {
                    if (this.status == 200) {
                        window.location.href = "list";
                    }
                }
                xhttp.open('GET',`delete?id=` + +id,true);
                xhttp.send();
            }
        }

    function handleEdit(id) {
        window.location.href = "edit?id=" + id;
    }