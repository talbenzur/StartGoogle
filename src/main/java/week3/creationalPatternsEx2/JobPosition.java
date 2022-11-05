package week3.creationalPatternsEx2;

import java.time.LocalDate;

//Implement a builder and pay attention to default values and optional/required values
public class JobPosition {

    private LocalDate publishedDate;
    private String title;
    private String description;
    private String location;
    private int salaryCap;
    private boolean isRemote;
    private int requiredExperienceYears;

    public static class Builder {
        //Required Parameters
        private LocalDate publishedDate;
        private String title;
        private boolean isRemote;

        //Optional Parameters
        private String description = "";
        private String location = "";
        private int salaryCap = 0;
        private int requiredExperienceYears = 0;

        public Builder(LocalDate publishedDate, String title, boolean isRemote) {
            this.publishedDate = publishedDate;
            this.title = title;
            this.isRemote = isRemote;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder salaryCap(int salaryCap) {
            this.salaryCap = salaryCap;
            return this;
        }

        public Builder requiredExperienceYears(int requiredExperienceYears) {
            this.requiredExperienceYears = requiredExperienceYears;
            return this;
        }

        public JobPosition build() {
            return new JobPosition(this);
        }

    }

    public JobPosition(Builder builder) {
        this.publishedDate = builder.publishedDate;
        this.title = builder.title;
        this.description = builder.description;
        this.location = builder.location;
        this.salaryCap = builder.salaryCap;
        this.isRemote = builder.isRemote;
        this.requiredExperienceYears = builder.requiredExperienceYears;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "publishedDate=" + publishedDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", salaryCap=" + salaryCap +
                ", isRemote=" + isRemote +
                ", requiredExperienceYears=" + requiredExperienceYears +
                '}';
    }
}
