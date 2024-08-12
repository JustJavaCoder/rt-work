package nba.clippers.rtwork.service;

import nba.clippers.rtwork.db.entity.ProjectInfo;

import java.util.List;

public interface ProjectService {

    List<ProjectInfo> findApplPage();

    int saveProject(ProjectInfo projectInfo);

}
