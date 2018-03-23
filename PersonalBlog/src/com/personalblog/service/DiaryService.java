package com.personalblog.service;

import java.util.List;

import com.personalblog.model.Blog;
import com.personalblog.model.Diary;

public interface DiaryService {

    void writediary(Diary diary);

    List<Diary> selectAllDiary();

    void deleteDiaryById(int diaryid);

}