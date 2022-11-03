package Week3.StructuralPatterns.Ex1;

public class Response {
    private String statusCode;
    private String body;

    public Response(String statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Response{" +
                "statusCode='" + statusCode + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
