package com.personalblog.mapper;

import java.util.List;

import com.personalblog.model.Diary;

public interface DiaryMapper {

    void writediary(Diary diary);

    List<Diary> selectAllDiary();

    void deleteDiaryById(int diaryid);

}