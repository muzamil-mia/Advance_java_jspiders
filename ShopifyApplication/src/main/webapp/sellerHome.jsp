<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "com.jsp.ShopifyApplication.dto.SellerDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./sellerHome.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<h1>Hello Seller</h1>
<%SellerDTO seller=(SellerDTO)request.getAttribute("seller"); %>
<div id="header">
      <nav id="nav">
        <div id="sub-nav">
          <div class="logo">
            <h2>Shopify</h2>
          </div>
          <div class="tabs">
            <h3 id="add">Add</h3>
            <h3 class="login2" id="profile">Profile</h3>
          </div>
        </div>
      </nav>
    </div>
  <div class="body">
    <div class="cards">
      <div class="card">
        <div class="product-picture">
          <h2>Product Name</h2>
        </div>
        <div class="product-details">
          <p>Price: $24</p>
          <p>Color: pink</p>
          <div class="buttons">
            <a href="#" class="update-btn">Update</a>
            <a href="#" class="delete-btn">Delete</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="form">
    <form action="AddItems" id="form">
      <h1>Add product details!</h1>
      <fieldset>
        <label for="item-name">Item Name</label>
        <input
          type="text"
          name="item-name"
          id=""
          placeholder=""
          required
        />
        
        <label for="brand">Brand</label>
        <input type="text" name="brand" required placeholder="" />
        <label for="price">Price</label>
        <input type="number" name="price" required>
        <label for="qty">Quantity</label>
        <input type="number" name="qty" required>
        <label for="address">Item Details</label>
        <textarea
          name=""
          id=""
          cols="20"
          rows="5"
          placeholder="...."
        ></textarea>
      </fieldset>
      <button>Add</button>
    </form>
  </div>
  <div id="profile-block">
    &nbsp;&nbsp;<strong style="background-color: transparent;">Profile</strong><span><i class='bx bx-x bx-sm' id="cross"></i></span>
    <hr style="margin: 5px 0;">
    <ul>
      <li>Name: <%=seller.getFirstName() %></li>
      <li>Last Name: <%=seller.getLastName() %></li>
      <li>Email: <%=seller.getEmail() %></li>
      <li>Phone: <%=seller.getPhone() %></li>
      <li>Address: <%=seller.getAddress() %></li>
    </ul>
    <div class="buttons">
      <a href="#" id="btn1">Update Profile</a>
      <a href="#" id="btn2">Logout</a>
    </div>
    
  </div>
  <script>
    let button = document.getElementById("add");
    let body1 = document.body;
    console.log(body1);
    let form = document.getElementById("form");
    button.addEventListener("click", (event) => {
      let display = form.style.display;
      if (display === "none" || display === "") {
      form.style.display = "block";
      // body1.classList.add("blur");
    } else {
      form.style.display = "none";
      body1.classList.remove('blur');
    }
    })

    document.addEventListener("click", function(event) {
        // Check if the clicked element is outside the form
        if (!form.contains(event.target) && event.target !== add) {
            form.style.display = "none";
        }
    });

    let profile = document.getElementById("profile");
    profile.addEventListener("click", (event) => {
      let block = document.getElementById("profile-block");
      let display = block.style.display;
      if(display === "none" || display === "") {
        block.style.right = "0px";
        block.style.transition = "all .7s"
      }else{
        block.style.right = "-460px";
      }
    })

    let cross = document.getElementById("cross");
    cross.onclick = function() {
      let block = document.getElementById("profile-block");
      block.style.right = "-460px";
      block.style.transition = "all .7s"
    }

  </script>
</body>
</html>