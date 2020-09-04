package com.halleta.duka.utils;



import com.halleta.duka.Exceptions.ExtractionException;
import com.halleta.duka.Exceptions.YoutubeRequestException;
import com.halleta.duka.network.YoutubeNetwork;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class YoutubePlayerUtils {

    private YoutubeNetwork youtubeNetwork;

    public YoutubePlayerUtils(YoutubeNetwork youtubeNetwork) {
        this.youtubeNetwork = youtubeNetwork;
    }

    /**
     * Extracts url of js player from embedded youtube page
     *
     * @param videoPageHtml youtube page
     * @return returns player url (like this one - 'https://www.youtube.com/yts/jsbin/player-vflkwPKV5/en_US/base.js')
     * @throws ExtractionException if there is no video player url in html code which means that
     *                             there is some problem with regular expression or html code provided
     */
    public String getJsPlayerUrl(String videoPageHtml) throws ExtractionException {
        Pattern pattern = Pattern.compile("\"assets\":.+?\"js\":\\s*(\"[^\"]+\")");
        Matcher matcher = pattern.matcher(videoPageHtml);

        if (matcher.find()) {
            String match = matcher.group(1);
            // Removing backslashes
            match = match.replaceAll("\\\\", "");
            // Removing leading and trailing quotes
            return match.replaceAll("^\"|\"$", "");
        } else
            throw new ExtractionException("No js video player url found");
    }

    /**
     * Downloads JS youtube video player
     *
     * @param playerUrl player url
     * @return js code of the player
     * @throws YoutubeRequestException if the player url is invalid or there is connection problems
     */
    public String downloadJsPlayer(String playerUrl) throws YoutubeRequestException {
        try {
            Response<ResponseBody> responseBody = youtubeNetwork.downloadWebpage(playerUrl);
            return responseBody.body().string();
        } catch (IOException | NullPointerException e) {
            throw new YoutubeRequestException("Error while downloading youtube js video player", e);
        }
    }
}
