package com.student.grademanagermvp.presenter;

import com.student.grademanagermvp.contract.MainFrameContract;
import com.student.grademanagermvp.model.request.RequestInterface;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;

/**
 * Created by huangbiao on 2016/10/31.
 */
public class MainFramePresenterTest {

    private MainFramePresenter presenter;

    @Mock
    private MainFrameContract.MainFrameView view;
    @Mock
    private RequestInterface api;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        RxUnitTestTools.openRxTools();
        // 生成mock对象
        view = mock(MainFrameContract.MainFrameView.class);
        api = mock(RequestInterface.class);

        presenter = new MainFramePresenter();
    }

    @Test
    public void testRxJava() throws Exception {

    }
}