package week3.structuralPatterns.ex1;

public class Response {
    private int statusCode;
    private String body;

    public Response(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }
    public Response(int statusCode) {
        this.statusCode = statusCode;
        this.body = null;
    }


    @Override
    public String toString() {
        return "Response{" +
                "statusCode='" + statusCode + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
