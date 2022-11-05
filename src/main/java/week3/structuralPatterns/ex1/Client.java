package week3.structuralPatterns.ex1;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        String url = "https://reqres.in/api/users/2";

        // get request:
        Response getRes = HttpFacade.get(url);
        System.out.println(getRes);

        // post
        Response postRes = HttpFacade.post(url, "tal@gmail.com", "student");
        System.out.println(postRes);


        // put
        Response putRes = HttpFacade.put(url, "tal", "123456");
        System.out.println(putRes);

        // patch
        Response patchRes = HttpFacade.patch(url, "tal", "student");
        System.out.println(patchRes);

        // delete
        Response deleteRes = HttpFacade.delete(url);
        System.out.println(deleteRes);
    }

}
