package com.personalblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.mapper.DiaryMapper;
import com.personalblog.model.Blog;
import com.personalblog.model.Diary;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryMapper diarymapper;

    @Override
    public void writediary(Diary diary) {
        diarymapper.writediary(diary);

    }

    @Override
    public List<Diary> selectAllDiary() {
        List<Diary> diarys =this.diarymapper.selectAllDiary();
        return diarys;
    }

    @Override
    public void deleteDiaryById(int diaryid) {
        diarymapper.deleteDiaryById(diaryid);

    }

}