package view;


import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Grade;
/**
 * 搜索页面
 * @author 钟恩俊
 *
 */
public class SearchPage extends BorderPane{
	private StudentTable tb;
	private Button sbt;
	private Button modify;
	//private Button add;
	private Button delete;
	private TextField idtf;
	private TextField nametf;
	private Label idlb;
	private Label namelb;
	private Pagination pg;
	private Label gradelb;
	private Label majorlb;
	private Label classlb;
	private ComboBox<String> gradecb;
	private ComboBox<String> majorcb;
	private ComboBox<String> classcb;
	
	public SearchPage() {
		
		tb=new StudentTable();
		gradelb=new Label("年级: ");
    	majorlb=new Label("分科: ");
    	classlb=new Label("班级: ");
    	
    	//ObservableList<String> departments = FXCollections.observableArrayList(getDepartmentList());
    	gradecb=new ComboBox<>();
    	ArrayList<String> departments=getDepartmentList();
    	if(departments!=null)
    		gradecb.getItems().addAll(departments);
    	majorcb=new ComboBox<>();
    	classcb=new ComboBox<>();
    	gradecb.valueProperty().addListener(new ChangeListener<String>() {
    		//当下拉框的值改变时，设置专业下拉框的items
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				ArrayList<String> majors = getMajorList(newValue);
				majorcb.getItems().clear();
				majorcb.getItems().addAll(majors);
			}
    		
    	});
    	majorcb.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				ArrayList<String> classes = getClassList(newValue);
				classcb.getItems().clear();
				classcb.getItems().addAll(classes);
			}
    		
    	});
		sbt=new Button("搜索");
		modify=new Button("修改");
		//add=new Button("增加");
		delete=new Button("删除");
		idtf=new TextField();
		nametf=new TextField();
		namelb=new Label("姓名: ");
		idlb=new Label("学号: ");
		pg=new Pagination(10,0);
		pg.setPageFactory((Integer pageIndex) -> {
            if (pageIndex >= 11) {
                return null;
            } else {
                return createPage(pageIndex);
            }
        });
		
		delete.setOnAction(e->{
			System.out.println(tb.row());
			System.out.println(tb.col());
		});
		
		sbt.setOnAction(e->{
			//搜索
		});
		
		modify.setOnAction(e->{
			test.show("没有权限");
			System.out.println(test.getRet());
		});
		/*add.setOnAction(e->{
			AddStudent.show();
		});*/
		
		HBox hb=new HBox();
    	hb.getChildren().addAll(idlb,idtf,namelb,nametf,gradelb,gradecb,majorlb,majorcb,classlb,classcb,sbt);
		hb.setSpacing(10);
		this.setTop(hb);
		this.setCenter(tb);
		VBox vb=new VBox();
		HBox buttonBox=new HBox();
		buttonBox.getChildren().addAll(modify,delete);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(20);
		vb.getChildren().addAll(pg,buttonBox);
		this.setBottom(vb);
	}
	/**
	 * 根据学院获取专业列表
	 * @param departName 学院名
	 * @return 专业名的数组
	 */
	private ArrayList<String> getMajorList(String departName){
		return null;
	}
	private ArrayList<String> getClassList(String majorName){
		return null;
	}
	private ArrayList<String> getDepartmentList(){
		
		return null;
	}
	private VBox createPage(int pageIndex) {
        VBox box = new VBox(5);
        return box;
    }
}
