package com.yaqin.fundamental.service;

import com.yaqin.fundamental.entity.Release;
import com.yaqin.fundamental.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReleaseServiceImp implements ReleaseService{
    @Autowired
    private ReleaseRepository releaseRepository;


    @Override
    public List<Release> listReleases() {
        return (List<Release>) releaseRepository.findAll();
    }
}
