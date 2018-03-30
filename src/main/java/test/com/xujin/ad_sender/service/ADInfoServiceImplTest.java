package test.com.xujin.ad_sender.service;

import com.xujin.ad_sender.AdSenderApplication;
import com.xujin.ad_sender.dao.ADInfoDao;
import com.xujin.ad_sender.entity.ADInfoEntity;
import com.xujin.ad_sender.entity.RecommendEntity;
import com.xujin.ad_sender.service.ADInfoServiceImpl;
import com.xujin.ad_sender.service.RegisterService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.internal.runners.JUnit44RunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.SocketUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * ADInfoServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 30, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdSenderApplication.class)
public class ADInfoServiceImplTest {

    @Autowired
    ADInfoDao adInfoDao;
    @Autowired
    RegisterService registerService;
    @Autowired
    ADInfoServiceImpl adInfoServiceimpl;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: InitADInformation()
     */
    @Test
    public void testInitADInformation() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addADInfo(ADInfoEntity adInfoEntity)
     */
    @Test
    public void testAddADInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updateADInfo(ADInfoEntity adInfoEntity)
     */
    @Test
    public void testUpdateADInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteADInfo(Integer ADID)
     */
    @Test
    public void testDeleteADInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: recommendAD(String UserName)
     */
    @Test
    public void testRecommendAD() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getsimiliraty(String str1, String str2)
     */
    @Test
    public void testGetsimiliraty() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: ADsort(List<RecommendEntity> recommendEntities)
     */
    @Test
    public void testADsort() throws Exception {
        String UserName = "xu";
        List<RecommendEntity> recommendEntities = new ArrayList<>();
        Map<String, Object> userFeatures = registerService.getUserFeatures(UserName);
        List<ADInfoEntity> adList = adInfoDao.RecommendADList(userFeatures.get("sex").toString());
        System.out.println(adList);
        for (ADInfoEntity adInfoEntity : adList) {
            RecommendEntity recommendEntity = new RecommendEntity();
            recommendEntity.setAdInfoEntity(adInfoEntity);
            recommendEntity.setSimiler((float) 1);
            recommendEntities.add(recommendEntity);
        }
        System.out.println(userFeatures);
        System.out.println(recommendEntities);
        System.out.println("----------------------");
        System.out.println(adInfoServiceimpl.ADsort(recommendEntities));

//TODO: Test goes here... 
    }


} 
