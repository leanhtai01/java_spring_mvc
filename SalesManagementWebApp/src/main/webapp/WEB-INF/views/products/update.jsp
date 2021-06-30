<%-- 
    Document   : update
    Created on : Jun 22, 2021, 1:29:29 AM
    Author     : HuuDepTrai
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/product.css">
        <title>Update</title>
        <script>
            function validData() {
                let name = document.getElementsByName("name")[0].value;
                let weight = document.getElementsByName("weight")[0].value;
                let price = document.getElementsByName("price")[0].value;
                if (!name) {
                    alert("Please Enter Name!");
                    return false;
                } if (!weight) {
                    alert("Please Enter Weight!");
                    return false;
                } if (!price) {
                    alert("Please Enter Price!");
                    return false;
                }
            }
            
            function back() {
                window.location.href="list";
            }
        </script>
    </head>
    <body>
        <section id="productAdd">
            <c:if test = "${product.id == null}">
            <h1>Add Product</h1>
            </c:if>
            <c:if test = "${product.id != null}">
            <h1>Edit Product</h1>
            </c:if>
            <form action="save" method="POST" onsubmit="return validData()">
                <div class="form-group" style="display: none">
                  <label for="id">ID</label>
                  <input type="text" class="form-control" id="id" name="id" value="${product.id}">
                </div>
                <div class="form-group">
                  <label for="exampleInputName">Name</label>
                  <input type="text" class="form-control" id="exampleInputName" placeholder="Enter Name" name="name" maxlength="50" value="${product.name}">
                </div>
                <div class="form-group">
                  <label for="exampleInputWeight">Weight</label>
                  <input type="number" class="form-control" id="exampleInputWeight" placeholder="Enter Weight" name="weight" value="${product.weight}">
                </div>
                <div class="form-group">
                  <label for="exampleInputPrice">Price</label>
                  <input type="number" class="form-control" id="exampleInputPrice" placeholder="Enter Price" name="price" value="${product.price}">
                </div>
                <button type="submit" class="btn btn-primary">
                    <c:if test = "${product.id == null}">Add</c:if>
                    <c:if test = "${product.id != null}">Edit</c:if>
                </button>
                <button type="button" class="btn btn-secondary ml-4" onClick="back()">Back</button>
              </form>
        </section>
    </body>
</html>
