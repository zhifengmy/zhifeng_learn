package com.ludas.tbschedule;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;

import java.util.Comparator;
import java.util.List;

public class TBTaskTest  implements IScheduleTaskDealSingle<String> {

    public boolean execute(String s, String s2) throws Exception {
        return false;
    }

    public List<String> selectTasks(String s, String s1, int i, List<TaskItemDefine> list, int i1) throws Exception {
        return null;
    }

    public Comparator<String> getComparator() {
        return null;
    }
}
