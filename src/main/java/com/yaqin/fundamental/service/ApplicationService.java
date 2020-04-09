package com.yaqin.fundamental.service;

import com.yaqin.fundamental.entity.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> listApplications();
    Application findApplication(long id);
}
