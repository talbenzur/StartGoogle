package week3.creationalPatternsEx2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        JobPosition job = new JobPosition.Builder(LocalDate.of(2022, 11, 01), "Teacher", true)
                .description("Best job").salaryCap(10000).requiredExperienceYears(2).build();
        System.out.println(job.toString());
    }
}
