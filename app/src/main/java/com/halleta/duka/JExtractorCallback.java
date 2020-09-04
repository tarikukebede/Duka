package com.halleta.duka;


import com.halleta.duka.Exceptions.YoutubeRequestException;
import com.halleta.duka.Models.Youtube.videoData.YoutubeVideoData;

public interface JExtractorCallback {

    void onSuccess(YoutubeVideoData videoData);

    void onNetworkException(YoutubeRequestException e);

    void onError(Exception exception);
}
