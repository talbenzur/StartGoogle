package Week3.StructuralPatterns.Ex1;

public class Client {
    public static void main(String[] args) {
        String url = "https://reqres.in/api/users/2";

        // get request:
        Response getRes = HttpFacade.get(url);
        System.out.println(getRes);

        // post
        Response postRes = HttpFacade.post(url, "tal", "student");
        System.out.println(postRes);


        // put
        Response putRes = HttpFacade.put(url, "tal", "student");
        System.out.println(putRes);

        // patch
        Response patchRes = HttpFacade.patch(url, "tal!", "student");
        System.out.println(patchRes);

        // delete
        Response deleteRes = HttpFacade.delete(url);
        System.out.println(deleteRes);
    }

}
