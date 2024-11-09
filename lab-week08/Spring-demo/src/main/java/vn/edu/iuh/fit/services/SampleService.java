package vn.edu.iuh.fit.services;

import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public String doFoo(){
        return "Something stupid, sometime smart";
    }
    public double Sum(double a, double b){
        return a + b;
    }
}
