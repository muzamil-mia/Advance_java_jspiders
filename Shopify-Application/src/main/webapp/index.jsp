<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./index.css" />
</head>
<body>
<main>
      <div id="header">
        <nav id="nav">
          <div id="sub-nav">
            <div class="logo">
              <h2>Shopify</h2>
            </div>
            <div class="tabs">
              <h3 class="login1">Buy</h3>
              <h3 class="login2">Sell</h3>
            </div>
          </div>
        </nav>
      </div>
      <div id="body">
        <div id="heading">
          <!-- <h1 style="color: white;">Welcome to shopify</h1> -->
        </div>
        <div class="login-block1">
          <form action="loginBuyer" class="form">
            <h2 style="color: white;">Login Buyer</h2>
            <label class="label" for="email">Email</label>
            <input class="input" type="email" name="email" placeholder="Enter your email">
            <label class="label" for="password">Password</label>
            <input class="input" type="password" name="password" placeholder="Enter your password">
            
          <input class="input" type="submit" value="login">
          </form>
          <p class="register" style="color: white;">Not Registered? <a href="registerBuyer.html">create an account</a></p>
          <p class="forget"><a href="">forget password</a></p>
        </div>

        //seller login form
        <div class="login-block2">
          <form action="loginSeller" class="form">
            <h2 style="color: white;">Login Seller</h2>
            <label for="email">Email</label>
            <input type="email" name="email" placeholder="Enter your email" required>
            <label for="password">Password</label>
            <input type="password" name="password" placeholder="Enter your password" required>
            <input type="submit" value="login">
          </form>
          <p class="register" style="color: white;">Not Registered? <a href="registerSeller.html">create an account</a></p>
          <p class="forget"><a href="">forget password</a></p>
        </div>
      </div>
 
    </main>
    <script src = "./index.js"></script>
</body>
</html>
