package com.example.handy.view.adapter;

import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.handy.R;
import com.example.handy.core.bean.RecommendCourseData;
import com.example.handy.utils.ImageLoader;
import com.example.handy.view.viewHolder.CourseViewHolder;

import java.util.List;

public class RecommendCourseAdapter extends BaseQuickAdapter<RecommendCourseData, CourseViewHolder> {

    private boolean isMainPage;


    public RecommendCourseAdapter(int layoutResId, @Nullable List<RecommendCourseData> data) {
        super(layoutResId, data);
    }

    public void isCollectPage() {
        isMainPage = true;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(CourseViewHolder helper, RecommendCourseData item) {
        // 设置标题
        if (!TextUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.recommend_course_title, item.getTitle());
        }
        //设置描述
        if (!TextUtils.isEmpty(item.getDescription())) {
            helper.setText(R.id.recommend_course_description, item.getDescription());
        }
        // 设置作者
        if (!TextUtils.isEmpty(item.getAuthor())) {
            helper.setText(R.id.recommend_course_author, item.getAuthor());
        }

        // 设置图片
        if (!TextUtils.isEmpty(item.getImgUrl())) {
            ImageLoader.load(mContext, item.getImgUrl(), helper.getView(R.id.recommend_course_image));
        }
    }
}