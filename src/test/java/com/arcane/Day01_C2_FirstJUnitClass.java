package com.arcane;

import org.junit.*;

public class Day01_C2_FirstJUnitClass {
//@Test : test case olustur. Bu test cases olusturma ve kosturmaya yardimci olur
// @Before : Runs before each @Test annotation. tekrarlanan pre condition icin kullanilir
// @After : Runs after each @Test annotation. tekrarlanan post conditions icin kullanilir
// @AfterClass, @BeforeClass
// @Ignore: test case atlatmak icin kullanilir
@Before
    public void setUp(){
    System.out.println("Bu bir setUp Methodudur");
}

@Test
    public void test01(){
    System.out.println("test case 1");
}
@Ignore
@Test
    public void test02(){
    System.out.println("test case 2");
}

    @Test
    public void test03() {
        System.out.println("test case 3");
}
@After
    public void tearDown(){
    System.out.println("Bu bir tearDown methodudur");
}
/*
    JUnit Assertion
    Expected=actual  ise assertion yapılır
 */
@Test
    public void assertion(){
    System.out.println("assertion test calıştı");

    //1.Assert.assertTrue()
    Assert.assertTrue(3==3);  //ters gecer

    //2.Assert.assertFalse()
    Assert.assertFalse(3==4);  //test geçer

    Assert.assertFalse("Selenium".contains("a"));  //test başarılı

    // Assert.assertEquals()
    Assert.assertEquals("java","java"); //test basarili
    Assert.assertEquals("Java","javascript"); //test basarısız
}
}
