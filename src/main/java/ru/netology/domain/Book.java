package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(String name, String author) {
        super(name);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

   // public Product[] searcyBy(String text) {
  //      Product[] result = new Product[0];
    //    for (Product product : productRepository.findAll()) {
      //      if (matches(product, text)) {
        //        Product[] tmp = new Product[result.length + 1];
          //      System.arraycopy(result, 0, tmp, 0, result.length);
            //    tmp[tmp.length - 1] = product;
              //  result = tmp;
        //    }
     //   }
       // return result;
 //   }

