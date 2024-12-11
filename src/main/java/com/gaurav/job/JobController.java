package com.gaurav.job;

import com.gaurav.job.model.JobPost;
import com.gaurav.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JobController {
   @Autowired
   private JobService Service;
    @GetMapping({"/","/home"})
    public  String home()
    {
        return "home";
    }
    @GetMapping("/addjob")
    public String addjob()
    {
        return "addjob";
    }
    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost,Model model) {
        model.addAttribute("jobPost", jobPost);
        Service.addJobPost(jobPost);
        //System.out.println(jobPost);
        return "success";

    }
    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {

        List<JobPost> jobPosts = Service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }


}
