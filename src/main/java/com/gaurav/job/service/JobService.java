package com.gaurav.job.service;

import com.gaurav.job.model.JobPost;
import com.gaurav.job.repo.JobRepo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class JobService {
    @Autowired
    public JobRepo repo;



    //method to return all JobPosts
    public List<JobPost> returnAllJobPosts() {
        return repo.returnAllJobPosts();


    }






    public void addJobPost(JobPost jobPost) {
        repo.addJobPost(jobPost);

    }


}