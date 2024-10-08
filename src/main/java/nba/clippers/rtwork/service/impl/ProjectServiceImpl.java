package nba.clippers.rtwork.service.impl;

import nba.clippers.rtwork.db.entity.ProjectInfo;
import nba.clippers.rtwork.db.mapper.ProjectInfoMapper;
import nba.clippers.rtwork.db.vo.ProjectInfoVO;
import nba.clippers.rtwork.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectInfoMapper projectInfoMapper;

    @Override
    public List<ProjectInfo> findApplPage() {


     List<ProjectInfo>  projectInfoList=  projectInfoMapper.selectAll();


        return projectInfoList;
    }

    @Override
    public int saveProject(ProjectInfo projectInfo) {

        ProjectInfoVO vo = new ProjectInfoVO();
        projectInfo.setCreatedAt(new Date());
        projectInfo.setUpdatedAt(new Date());

        int i = projectInfoMapper.insert(projectInfo);

        return i;


    }
}
