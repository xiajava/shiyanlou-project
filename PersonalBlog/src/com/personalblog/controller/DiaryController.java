package com.personalblog.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personalblog.model.Blog;
import com.personalblog.model.Diary;
import com.personalblog.service.DiaryService;

@Controller
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @RequestMapping("writediary")
    public String writediary(Diary diary){
        //��ȡ��ǰ����
        Date currentTime = new Date();
         //������ת��Ϊָ����ʽ
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        diary.setTime(dateString);
        this.diaryService.writediary(diary);
        return "Dsuccess";
    }

    /*
     * ����ȫ�����ռ�
     */
    @RequestMapping("selectAllDiary")
    public String selectAllDiary(HttpServletRequest request){
        try {
            List<Diary> diarys = new ArrayList<Diary>();
            diarys =  this.diaryService.selectAllDiary();
            request.setAttribute("diarys", diarys);
            return "saylist";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    /*
     * ����ȫ���ռǣ�������ת���ռǹ���ҳ��
     */
    @RequestMapping("admindiary")
    public String selectAllDiary2(HttpServletRequest request){
        try {
            List<Diary> diarys = new ArrayList<Diary>();
            diarys =  this.diaryService.selectAllDiary();
            request.setAttribute("diarys", diarys);
            return "admindiary";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    /*
     * ɾ���ռ�
     */
    @RequestMapping("deleteDiaryById")
    public String deleteDiaryById(HttpServletRequest request){
        try {
            String id = request.getParameter("diaryid");
            int diaryid = Integer.parseInt(id);
            this.diaryService.deleteDiaryById(diaryid);
            return "redirect:admindiary";
        } catch (Exception e) {
            return null;    
        }
    }
}