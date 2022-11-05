package week3.structuralPatterns.ex1;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        String url = "https://reqres.in/api/users/2";

        //get
        Response getRes=FacadeHttp.get(url);
        System.out.println(getRes);

        //post
        Response postRes = FacadeHttp.post(url, "tal@gmail.com", "student");
        System.out.println(postRes);

        // put
        Response putRes = FacadeHttp.put(url, "tal", "123456");
        System.out.println(putRes);

        // patch
        Response patchRes = FacadeHttp.patch(url, "tal", "student");
        System.out.println(patchRes);

        //delete
        Response deleteRes = FacadeHttp.delete(url);
        System.out.println(deleteRes);


    }

}
