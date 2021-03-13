//Selenium Web Otomasyon
	- www.gittigidiyor.com sitesi açılır.
	- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
	- Login işlemi kontrol edilir.
	- Arama kutucuğuna bilgisayar kelimesi girilir.
	- Arama sonuçları sayfasından 2.sayfa açılır.
	- 2.sayfanın açıldığı kontrol edilir.
	- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
	- Seçilen ürün sepete eklenir.
	- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
	- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
	- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.

//Yukarıda istenilen aşamaların Kodlarını bir bütün halinde tamamlayabildiğim kadarıyla açıklamak istedim...

//Öncelikle program olarak int "IntelliJ IDE" platformunu kullandım. 
//Daha sonrasıda gerekli kütüphaneleri pom.xml'e "mvnrepository" sayfasından alarak ekledim.
//son olarak programları chromede çalıştırmak için dhrome driver indirmem gerekti onu da ekledim. 
//ve aşağıdaki gibi driver'ın yolunu gösterdim. 

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZeynepAytl\\Desktop\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//Yapmam gereken ilk adım www.gittigidiyor.com sitesini açmaktı.
        driver.navigate().to("https://www.gittigidiyor.com/"); //gitti gidiyor sitesini açar.

//Ana sayfanın açıldığı kontrol edilmek için bir süre beklettim.
        WebDriverWait wait = new WebDriverWait(driver,8);//Sayfayı Bekletir.

        driver.manage().window().maximize(); //chrom'u buyuk boyuta getirir.

//Giriş yap navbarda görünene kadar bekler ve tıklar
	WebElement navBarLogin = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]"))));
        navBarLogin.click();

//Giriş yap buttonu görünene kadar bekler ve göründükten sonra buttona tıklar.
//acılan giriş Yap Butonuna Tıklar
        WebElement loginClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a/span"))));
        loginClick.click();

//Üçüncü adım ise login işlemi. 
//Öncelikle yapmam gereken textler için veri göndermek olacak.
        //Username textbox'ı için veri gönderir
        WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[1]/div[1]/div[1]/div[2]/input"));
        username.sendKeys("testgittigidiyorzeynep@gmail.com"); //siteye kayıtlı email adresimiz.

        //Password textbox'ı için veri gönderir.
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[1]/div[2]/div/div[2]/input"));
        password.sendKeys("test1234"); //siteye kayıtlı şifremiz.

//daha sonra da giriş butonuna tıklayıp giriş işlemini gerçekleştireceğim.
        //Giriş Yap Butonuna Tıklar
        WebElement loginClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/div[2]/div[1]/input[13]"))));
        loginClick.click();

//arama kutucuğuna bilgisayar kelimesi gireceğim ve aratalım.
//Önce sayfada arama çubuğuna tıklarız.
        WebElement searchBarClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]"))));
        searchBarClick.click();

//Daha sonrasında çubuğa istediğimiz ürünün adını yazarız.
        //Arama cubuguna bilgisayar kelimesi girilir ve arama işlemi yapılır.
        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        search.sendKeys("bilgisayar");

//ve bul buttonuna tıklarız.
        WebElement searchClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button"))));
        searchClick.click();

	Thread.sleep(5);
//arama sonrası 2.sayfaya geçme.
        //Arama sonuçları sayfasından 2.sayfa açılır.
        //2.sayfanın açıldığı kontrol edilir kısımlarının otomatik geçişini sağlayamadım. Fakat devam etmek istediğim için direk geçiş linki koydum.
        driver.navigate().to("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");

//2.Sayfadaki ürünlerin hepsi getirilir.
        List<WebElement> listOfElements =  driver.findElements(By.xpath(".//*[@class='catalog-view clearfix products-container']/li"));

//Getirilen ürünlerden random ürün seçilir.
        Random rand = new Random();
        int randomIndex = rand.nextInt(listOfElements.size());
        WebElement randomProduct = listOfElements.get(randomIndex);

//Seçilen ürün text getirilir ve üstüne tıklanır.
        randomProduct.click();

//Ürün sepete eklenir.
        int  a =driver.findElements(By.id("add-to-basket")).size();

        if(a==1)
        {
            WebElement addToBasketElement = driver.findElement(By.id("add-to-basket"));

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", addToBasketElement);

        }
        else {
            System.out.println("...");
        }

        Thread.sleep(3000);
//Sepet açılır.
        WebElement selectBasket = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/a"))));
        selectBasket.click();

        Thread.sleep(3000);
//Sepetteki ürün sayısı 2 yapar.
        WebElement addDropdown = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div[4]/div/div[2]/select"));
        Select number = new Select(addDropdown);

        number.selectByIndex(1); //Ürün adedini 2 yapması için index 1 seçilmelidir.

        Thread.sleep(3000);
//Sepetteki ürünler sepetten silinir.
        WebElement deleteBasket = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div[3]/div/div[2]/div/a/i"))));
        deleteBasket.click();

        Thread.sleep(3000);
        driver.quit(); //programı çalışmayı durdurur.
    }
}


---Zeynep AYTOLU---





