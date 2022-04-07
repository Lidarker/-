package com.example.demo.controller;

import com.example.demo.bean.Room;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

@RequestMapping("/pic")
@CrossOrigin
@RestController
public class PicController {
    @Autowired
    private HttpServletResponse httpServletResponse;
    @Autowired
    private RoomService roomService;
    @RequestMapping(value="/getPic",method = RequestMethod.GET)
    public void getImage(@RequestParam("rid")int rid) throws IOException {
        Room room=roomService.getRoomById(rid);
        OutputStream os=null;
        BufferedImage image=null;
        try {
           File file=new File("D:\\-\\frontend\\public\\static\\img\\"+room.getRimage());
           FileInputStream fl=new FileInputStream(file);
            image = ImageIO.read(fl);
            System.out.println(room.getRimage());
            String type=room.getRimage().split("\\.")[1];
            httpServletResponse.setContentType("image/"+type);
            os = httpServletResponse.getOutputStream();
            if (image != null) {
                ImageIO.write(image, type, os);
            }
        }catch (Exception e){
            return;
        }
        finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
    }
}
