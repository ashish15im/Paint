import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import javax.swing.filechooser.*;
class Trial9 extends JPanel
{
    int t=0,x,y,x1,y1,x3,y3,x4,y4,flag=0;
    Color cg=new Color(0,0,0);
    Graphics2D g2;
    float fs=4f;
    static int WIDTH=PaintF.WIDTH1-100;
    static int HEIGHT=PaintF.HEIGHT1-240;
    BufferedImage bImage = new BufferedImage(WIDTH , HEIGHT ,BufferedImage.TYPE_INT_ARGB);
    //BufferedImage bImage1 = new BufferedImage(WIDTH, HEIGHT , BufferedImage.TYPE_INT_ARGB);
    BufferedImage bImage1;
    BufferedImage bImage2 = new BufferedImage(WIDTH , HEIGHT ,BufferedImage.TYPE_INT_RGB);
    BufferedImage bImage4;
    BufferedImage bImage3;
    BufferedImage bImage5 = new BufferedImage(WIDTH, HEIGHT , BufferedImage.TYPE_INT_ARGB);
    JFileChooser j1=new JFileChooser("/root/Desktop");
    JFileChooser j2=new JFileChooser("/root/Desktop/Frames");
    FileNameExtensionFilter f=new FileNameExtensionFilter("Image Files","jpg","jpeg","png","gif");
    Color cg1=new Color(255,255,255);
    //Color cg1=new Color(250,170,92);
    Trial9() throws Exception
    {
	bImage1=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB); 
	//g2.drawImage(bImage4,0,0,WIDTH,HEIGHT,WIDTH,0,0,HEIGHT,null);
	//bImage=ImageIO.read(new File("paint_app.png"));
	//bImage1=ImageIO.read(new File("paint_app.png"));
	Graphics g = bImage2.createGraphics();
	g.setColor(cg1);
	g.fillRect(0,0,WIDTH,HEIGHT);
	//g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 100)); 
	//Graphics g1 = bImage1.getGraphics();
	g.dispose();
	//g1.dispose();
    }
    public void open1() throws Exception
    {
	j1.setFileFilter(f);
	int x=j1.showOpenDialog(null);
	if(x==JFileChooser.APPROVE_OPTION)
	    {
		t=11;
		paint3();
		File f=j1.getSelectedFile();
		bImage3=ImageIO.read(f);
		//bImage4=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		//Graphics g1=bImage4.createGraphics();
		//g1.drawImage(bImage1,0,0,null);
		Graphics g=bImage1.createGraphics();
		g.drawImage(bImage3,0,0,WIDTH,HEIGHT,null);
		g.dispose();
		Graphics g1=bImage5.createGraphics();
		g1.drawImage(bImage3,0,0,WIDTH,HEIGHT,null);
		g1.dispose();
	    }
	repaint();
    }

    public void open2() throws Exception
    {
	j2.setFileFilter(f);
	int x=j2.showOpenDialog(null);
	if(x==JFileChooser.APPROVE_OPTION)
	    {
		t=17;
		paint3();
		File f=j2.getSelectedFile();
		bImage4=ImageIO.read(f);
		//bImage4=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		//Graphics g1=bImage4.createGraphics();
		//g1.drawImage(bImage1,0,0,null);
		Graphics g=bImage1.createGraphics();
		g.drawImage(bImage4,0,0,WIDTH,HEIGHT,null);
		g.dispose();
	    }
	repaint();
    }
	
    public void save1()throws Exception
    {
	Graphics g=bImage2.createGraphics();
	Graphics g1=bImage1.createGraphics();
	Graphics g2=bImage.createGraphics();
	BufferedImage bImage4 = new BufferedImage(WIDTH , HEIGHT ,BufferedImage.TYPE_INT_ARGB);
	Graphics g3=bImage4.createGraphics();
	g3.drawImage(bImage2,0,0,this);
	g3.drawImage(bImage1,0,0,WIDTH,HEIGHT,this);
	//g3.drawImage(bImage1,0,0,this);
	g3.drawImage(bImage,0,0,this);
	g3.dispose();
	int x=j1.showSaveDialog(null);
	if(x==JFileChooser.APPROVE_OPTION)
	    {
		int i;
		File f=j1.getSelectedFile();
		String s=j1.getName(f);
		String s2=f.getAbsolutePath();
		s2=s2+".PNG";
		System.out.println(s2);
		File of = new File(s2);
		ImageIO.write(bImage4,"PNG",of);
	    }
    }
    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	g2 = (Graphics2D) g; 
	//g2.setStroke(new BasicStroke(fs,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    	g2.drawImage(bImage2,0,0,this);
	//g2.drawImage(bImage1, 0, 0,WIDTH,HEIGHT,this);
	g2.drawImage(bImage1 ,0 , 0 ,this);
	g2.drawImage(bImage,0,0,this);
	//g2.drawImage(bImage3,0,0,this);
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setStroke(new BasicStroke(fs,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
	g2.setColor(cg);
	//paint1(g2);
	if(t==1)  //For Drawing a Line
	    {
		g2.drawLine(x,y,x4,y4);
	    }
	if(t==3) //For Drawing a Rectangle
	    {
		if(x4>=x&&y4>=y)
		    g2.drawRect(x,y,(x4-x),(y4-y));
		if(x4<x&&y4>y)
		    g2.drawRect(x4,y,(x-x4),(y4-y));
		if(x4<x&&y4<y)
		    g2.drawRect(x4,y4,(x-x4),(y-y4));
		if(x4>x&&y4<y)
		    g2.drawRect(x,y4,(x4-x),(y-y4));
	    }
	if(t==2)    //For Drawing an Oval
	    {
		if(x4>=x&&y4>=y)
		    g2.drawOval(x,y,(x4-x),(y4-y));
		if(x4<x&&y4>y)
		    g2.drawOval(x4,y,(x-x4),(y4-y));
		if(x4<x&&y4<y)
		    g2.drawOval(x4,y4,(x-x4),(y-y4));
		if(x4>x&&y4<y)
		    g2.drawOval(x,y4,(x4-x),(y-y4));
	    }
	if(t==4)   //For Drawing a Filled Oval
	    {
		if(x4>=x&&y4>=y)
		    g2.fillOval(x,y,(x4-x),(y4-y));
		if(x4<x&&y4>y)
		    g2.fillOval(x4,y,(x-x4),(y4-y));
		if(x4<x&&y4<y)
		    g2.fillOval(x4,y4,(x-x4),(y-y4));
		if(x4>x&&y4<y)
		    g2.fillOval(x,y4,(x4-x),(y-y4));
	    }
	if(t==5)   //For Drawing a Filled Rectangle
	    {
		if(x4>=x&&y4>=y)
		    g2.fillRoundRect(x,y,(x4-x),(y4-y),20,20);
		if(x4<x&&y4>y)
		    g2.fillRoundRect(x4,y,(x-x4),(y4-y),20,20);
		if(x4<x&&y4<y)
		    g2.fillRoundRect(x4,y4,(x-x4),(y-y4),20,20);
		if(x4>x&&y4<y)
		    g2.fillRoundRect(x,y4,(x4-x),(y-y4),20,20);
	    }
	if(t==9)  //For Eraser
	    { 
		g2.drawRect(x4-10,y4-10,20,20);
	    }
	if(t==16&&flag==0)//For Cropping the Image
	    {
		g2.drawRect(x,y,(x4-x),(y4-y));
	    }
    }




    public void paint1(Graphics2D g1, Graphics2D g2, Graphics2D g3)
    {
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setStroke(new BasicStroke(fs,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
	g2.setColor(cg);
	if(t==7) //For Clearing Screen
	    {
		g2.setComposite(AlphaComposite.Clear);
		g2.fillRect(0,0,WIDTH,HEIGHT);
	    }
	if(t==0||t==6)
	    {
		g3.setColor(cg1);;
		g3.fillRect(0,0,WIDTH,HEIGHT);
	    }
	if(t==1)  //For Drawing a Line
	    {
		g2.drawLine(x,y,x1,y1);
	    }
	if(t==2)  //For Drawing an Oval
	    {
		if(x1>=x&&y1>=y)
		    g2.drawOval(x,y,(x1-x),(y1-y));
		if(x1<x&&y1>y)
		    g2.drawOval(x1,y,(x-x1),(y1-y));
		if(x1<x&&y1<y)
		    g2.drawOval(x1,y1,(x-x1),(y-y1));
		if(x1>x&&y1<y)
		    g2.drawOval(x,y1,(x1-x),(y-y1));
	    }
	if(t==3)   //For Drawing a Rectangle
	    {
		if(x1>=x&&y1>=y)
		    g2.drawRect(x,y,(x1-x),(y1-y));
		if(x1<x&&y1>y)
		    g2.drawRect(x1,y,(x-x1),(y1-y));
		if(x1<x&&y1<y)
		    g2.drawRect(x1,y1,(x-x1),(y-y1));
		if(x1>x&&y1<y)
		    g2.drawRect(x,y1,(x1-x),(y-y1));
	    }
	if(t==4)  //For Drawing a Filled Oval
	    {
		if(x1>=x&&y1>=y)
		    g2.fillOval(x,y,(x1-x),(y1-y));
		if(x1<x&&y1>y)
		    g2.fillOval(x1,y,(x-x1),(y1-y));
		if(x1<x&&y1<y)
		    g2.fillOval(x1,y1,(x-x1),(y-y1));
		if(x1>x&&y1<y)
		    g2.fillOval(x,y1,(x1-x),(y-y1));
	    }
	if(t==5)  //FOr Drawing a Filled Rectangle
	    {
		if(x1>=x&&y1>=y)
		    g2.fillRoundRect(x,y,(x1-x),(y1-y),20,20);
		if(x1<x&&y1>y)
		    g2.fillRoundRect(x1,y,(x-x1),(y1-y),20,20);
		if(x1<x&&y1<y)
		    g2.fillRoundRect(x1,y1,(x-x1),(y-y1),20,20);
		if(x1>x&&y1<y)
		    g2.fillRoundRect(x,y1,(x1-x),(y-y1),20,20);
	    }
	if(t==8) //For Free Hand Drawing
	    {
		//g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
		g2.drawLine(x3,y3,x4,y4);
	    }
	if(t==9)  //For Eraser
	    {
		//cg1=g2.getColor();
		//g2.setColor(cg1);
		//g2.clearRect(x3,y3,10,10);
		g2.setComposite(AlphaComposite.Clear);
		g2.fillRect(x3-10,y3-10,20,20);
		//Rectangle2D.Double rect = new Rectangle2D.Double(0,0,x3,y3); 
		//g2.fill(rect);
	    }
	if(t==12)  //For Eraser
	    {
		g2.setComposite(AlphaComposite.Clear);
		g2.fillRect(x4-10,y4-10,20,20);
	    }
	if(t==11) //For Opening an Image
	    {
		g2.setComposite(AlphaComposite.Clear);
		g2.fillRect(0,0,WIDTH,HEIGHT);
		g3.setColor(cg1);
		g3.fillRect(0,0,WIDTH,HEIGHT);
	    }
	if(t==13)  //For Translucent
	    {
		//bImage4 = new BufferedImage(WIDTH , HEIGHT ,BufferedImage.TRANSLUCENT);
		//Graphics2D g4=bImage4.createGraphics();
		//g4.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.1f));
		g1.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.10f));
		g1.drawImage(bImage1,0,0,null);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.20f));
		//g4.drawImage(bImage,0,0,null);	
		g2.drawImage(bImage2,0,0,null);
		//g2.drawImage(bImage,0,0,WIDTH,HEIGHT,0,HEIGHT,WIDTH,0,null);
	    }
	if(t==14)   // For Horizontal FLip
	    {
		bImage4 = new BufferedImage(WIDTH , HEIGHT ,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g4=bImage4.createGraphics();
		g4.drawImage(bImage,0,0,null);
		//bImage = new BufferedImage(WIDTH , HEIGHT , BufferedImage.TYPE_INT_ARGB);
		//Graphics2D g5= bImage.createGraphics();
		g2.setComposite(AlphaComposite.Clear);
		g2.fillRect(0,0,WIDTH,HEIGHT);
		g2.setComposite(AlphaComposite.Src);
	        g2.drawImage(bImage4,0,0,WIDTH,HEIGHT,0,HEIGHT,WIDTH,0,null);
		bImage4 = new BufferedImage(WIDTH , HEIGHT ,BufferedImage.TYPE_INT_ARGB);
		g4=bImage4.createGraphics();
		g4.drawImage(bImage1,0,0,null);
		g1.setComposite(AlphaComposite.Clear);
		g1.fillRect(0,0,WIDTH,HEIGHT);
		g1.setComposite(AlphaComposite.Src);
	        g1.drawImage(bImage4,0,0,WIDTH,HEIGHT,0,HEIGHT,WIDTH,0,null);
	    }
	if(t==15)    // For Vertical Flip
	    {
		bImage4 = new BufferedImage(WIDTH , HEIGHT ,BufferedImage.TRANSLUCENT);
		Graphics2D g4=bImage4.createGraphics();
		g4.drawImage(bImage,0,0,null);
		//bImage = new BufferedImage(WIDTH , HEIGHT , BufferedImage.TYPE_INT_ARGB);
		//Graphics2D g5= bImage.createGraphics();
		g2.setComposite(AlphaComposite.Clear);
		g2.fillRect(0,0,WIDTH,HEIGHT);
		g2.setComposite(AlphaComposite.Src);
	        //g2.drawImage(bImage4,0,0,WIDTH,HEIGHT,WIDTH,0,0,HEIGHT,null);
		g2.drawImage(bImage4,0,0,WIDTH,HEIGHT,WIDTH,0,0,HEIGHT,this);
		bImage4 = new BufferedImage(WIDTH , HEIGHT ,BufferedImage.TYPE_INT_ARGB);
		g4=bImage4.createGraphics();
		g4.drawImage(bImage1,0,0,null);
		g1.setComposite(AlphaComposite.Clear);
		g1.fillRect(0,0,WIDTH,HEIGHT);
		g1.setComposite(AlphaComposite.Src);
		g1.drawImage(bImage4,0,0,WIDTH,HEIGHT,WIDTH,0,0,HEIGHT,this);     //Please Subtract Any Changes in Width From Here
		//g1.drawImage(bImage4,0,0,null);
	    }
	if(t==16) //For Cropping the Image
	    {
		bImage4 = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g4=bImage4.createGraphics();
		g4.drawImage(bImage.getSubimage(x,y,x1-x,y1-y),0,0,WIDTH,HEIGHT,null);
		g2.setComposite(AlphaComposite.Clear);
		g2.fillRect(0,0,WIDTH,HEIGHT);
		g2.setComposite(AlphaComposite.Src);
		g2.drawImage(bImage4,0,0,null);
		bImage5 = new BufferedImage(WIDTH,HEIGHT ,BufferedImage.TYPE_INT_ARGB);
		g4=bImage5.createGraphics();
		g4.drawImage(bImage1.getSubimage(x,y,x1-x,y1-y),0,0,WIDTH,HEIGHT,null);
		g1.setComposite(AlphaComposite.Clear);
		g1.fillRect(0,0,WIDTH,HEIGHT);
		g1.setComposite(AlphaComposite.Src);
		g1.drawImage(bImage5,0,0,null);
		//Graphics2D g5=bImage3.createGraphics();
		//g5.drawImage(bImage1,0,0,null);
		//g5.dispose();
		flag=-1;
	    }
	if(t==17)
	    {	
		g1.setComposite(AlphaComposite.Clear);
		g1.fillRect(0,0,WIDTH,HEIGHT);
		g1.setComposite(AlphaComposite.Src);
		g1.drawImage(bImage5,0,0,WIDTH,HEIGHT,null);
	    }
    }
    public void paint3()
    {
	Graphics2D g2 = bImage.createGraphics();
	Graphics2D g3 = bImage2.createGraphics();
	Graphics2D g1 = bImage1.createGraphics();
	paint1(g1,g2,g3);
	g2.dispose();
	g3.dispose();
	g1.dispose();
    }
}
class PaintF
{
    static int flag1=-1;
    static int WIDTH1=700, HEIGHT1=600;
    JFrame f;
    // ImageIcon i=new ImageIcon("paint_app.png");
    ImageIcon i;
    int x,x1,y,y1;
    JRadioButton b,b1,b2,b3,b5,b6,b7,b14;
    JButton b4,b8,b9,b10,b11,b12,b13,b15;
    JMenuBar mb;
    JMenu m;
    JPopupMenu p;
    JMenuItem mi,mi1,mi2,mi3;       //For MenuBar
    JMenuItem mp,mp1,mp2,mp3,mp4;  //For PopupMenu 1(PencilSize)
    JPanel j1=new JPanel();         //For Buttons to be arranged in a grid
    PaintF(String S) throws Exception
    {
	//Image i1=i.getImage();
	//Image i2=i1.getScaledInstance(20,30,java.awt.Image.SCALE_SMOOTH ) ;
	//Image i2=i1.getScaledInstance(20,30,4);
	//Icon i3=new ImageIcon(i2);
	//i=addIcon("paint_app.png",40,40);
	flag1++;
	f=new JFrame(S);
	Trial9 t9=new Trial9();
	mb=new JMenuBar();
	t9.setBackground(Color.WHITE);
	f.add(t9);
	t9.setBounds(40,40,t9.WIDTH,t9.HEIGHT);
	m=new JMenu("File");
	mb.add(m);
	m.setMnemonic(KeyEvent.VK_F);
	mi=new JMenuItem("New",KeyEvent.VK_N);
	mi1=new JMenuItem("Save",KeyEvent.VK_S);
	mi2=new JMenuItem("Exit",KeyEvent.VK_E);
	mi3=new JMenuItem("Open",KeyEvent.VK_O);
	i=addIcon("line-2-xxlb.png",40,40);
	//b=new JRadioButton("Line",i);
	b=new JRadioButton(i);
	i=addIcon("circleb.png",40,40);
	//b1=new JRadioButton("Oval",i);
	b1=new JRadioButton(i);
	i=addIcon("square-outline-xxlb.png",40,40);
	//b2=new JRadioButton("Rectangle",i)
	b2=new JRadioButton(i);
	i=addIcon("eraser-xxlb.png",40,40);
	//b3=new JRadioButton("Eraser",i);
	b3=new JRadioButton(i);
	i=addIcon("edit-9-xxlb.png",40,40);
	//b5=new JRadioButton("Free",i);
	b5=new JRadioButton(i);
	i=addIcon("circle-xxlb.png",40,40);
	//b6=new JRadioButton("F.Oval",i);
	b6=new JRadioButton(i);
	i=addIcon("square-ios-app-xxlb.png",40,40);	
	//b7=new JRadioButton("F.Rect",i);
	b7=new JRadioButton(i);
	i=addIcon("text-bg-color-xxlb.png",40,40);
	//b8=new JButton("BColor",i);
	b8=new JButton(i);
	i=addIcon("border-color-xxlb.png",40,40);
	//b4=new JButton("FColor",i);
	b4=new JButton(i);
	i=addIcon("home-6-xxlb.png",40,40);
	//b9=new JButton("C.Scr",i);
	b9=new JButton(i);
	i=addIcon("gear-xxlb.png",40,40);
	//b10=new JButton("Psize",i);  //For PopupMenu
	b10=new JButton(i);  //For PopupMenu
	b11=new JButton("Translucent");   //For Making the Image Translucent
	i=addIcon("flip-horizontal-xxlb.png",40,40);
	//b12=new JButton("H.Flip",i);
	b12=new JButton(i);
	i=addIcon("flip-vertical-xxlb.png",40,40);
	//b13=new JButton("V.Flip",i);
	b13=new JButton(i);
	i=addIcon("crop-xxl.png",40,40);
	//b14=new JRadioButton("Crop",i); //For Cropping the Image
	b14=new JRadioButton(i); //For Cropping the Image
	i=addIcon("frame-xxlb.png",40,40);
	//b15=new JButton("Add Frame",i);
	b15=new JButton(i);
	p=new JPopupMenu("Select Size");
	mp=new JMenuItem("V. Thin");
	mp1=new JMenuItem("Thin");
	mp2=new JMenuItem("Medium");
	mp3=new JMenuItem("Thick");
	mp4=new JMenuItem("V.Thick");
	p.add(mp);
	p.add(mp1);
	p.add(mp2);
	p.add(mp3);
	p.add(mp4);
	m.add(mi);
	m.addSeparator();
	m.add(mi3);
	m.addSeparator();
	m.add(mi1);
	m.addSeparator();
	m.add(mi2);
	m.addSeparator();
	ButtonGroup bg=new ButtonGroup();
	j1.setBounds(40,420,680,540);
	//b.setBounds(40,420,60,40);
	//b1.setBounds(120,420,60,40);
	//b2.setBounds(200,420,80,40);
	//b3.setBounds(300,420,80,40);
	//b4.setBounds(400,420,80,40);
	//b5.setBounds(40,480,60,40);
	//b6.setBounds(120,480,80,40);
	//b7.setBounds(220,480,80,40);
	//b8.setBounds(320,480,80,40);
	//b9.setBounds(420,480,80,40);
	j1.setSize(640,80);
	j1.setLayout(new GridLayout(2,8));
	bg.add(b);
	bg.add(b1);
	bg.add(b2);
	bg.add(b3);
	bg.add(b5);
	bg.add(b6);
	bg.add(b7);
	bg.add(b14);
	//b1.setBackground(Color.RED);
       	b5.setSelected(true);
	mi3.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    try
			{
			    t9.open1();
			}
		    catch(Exception e1)
			{
			}
		}
	    });
	
	mi2.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		     if(flag1!=0)
			{
			    f.setVisible(false);
			    f.revalidate();
			    flag1=flag1-1;
			}
		     else
			 if(flag1==0)
			     {
				 System.exit(0);
			     }
		}
	    });
	mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.ALT_MASK));
	mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.ALT_MASK));
	mi1.addActionListener(new ActionListener()
	  {
		public void actionPerformed(ActionEvent e)
		{
		    try
			{
			    t9.save1();
			}
		    catch(Exception e2)
			{
			}
		}
	    });
	mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.ALT_MASK));
	mi.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    try
			{
			    new PaintF("Frame");
			}
		    catch(Exception e2)
			{
			}
		}

	    });
	mp.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    t9.fs= 1f;
		}
	    });
	mp1.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    t9.fs= 3f;
		}
	    });
	mp2.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    t9.fs= 4f;
		}
	    });
	mp3.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    t9.fs= 6f;
		}
	    });
	mp4.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    t9.fs= 8f;
		}
	    });
	mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.ALT_MASK));
	t9.addMouseMotionListener(new MouseMotionAdapter()
	    {
		public void mouseDragged(MouseEvent e)
		{
		    //Graphics g=c.getGraphics();
		    //g.setColor(cg);
		    t9.x3=t9.x4;
		    t9.y3=t9.y4;
		    t9.x4=e.getX();
		    t9.y4=e.getY();
		    if(b5.isSelected()==true)
			{
			    t9.t=8;
			    t9.paint3();
			    t9.repaint();
			    // g.drawLine(e.getX(),e.getY(),e.getX(),e.getY());
			}
		     if(b3.isSelected()==true)
			{ 
			    t9.t=9;
			    t9.paint3();
			    t9.repaint();
			    //g.clearRect(e.getX(),e.getY(),e.getX()+2,e.getY()+2);
			}
		     if(b.isSelected()==true)
			 {
			     t9.t=1;
			     t9.repaint();
			 }
		     if(b1.isSelected()==true)
			 {
			     t9.t=2;
			     t9.repaint();
			 }
		     if(b2.isSelected()==true)
			 {
			     t9.t=3;
			     t9.repaint();
			 }
		     if(b6.isSelected()==true)
			 {
			     t9.t=4;
			     t9.repaint();
			 }
		     if(b7.isSelected()==true)
			 {
			     t9.t=5;
			     t9.repaint();
			 }
		     if(b14.isSelected()==true)
			 {
			     t9.flag=0;
			     t9.t=16;
			     t9.repaint();
			 }
		}
	    }); 
	t9.addMouseListener(new MouseAdapter()
	    {
		public void mousePressed(MouseEvent e)
		{
		    t9.x=e.getX();
		    t9.x4=t9.x;
		    t9.y=e.getY();
		    t9.y4=t9.y;
		}
		public void mouseReleased(MouseEvent e1)
		{
		    t9.x1=e1.getX();
		    t9.y1=e1.getY();
		    //Graphics g=c.getGraphics();
		    //g.setColor(cg);
		    if(b.isSelected()==true)
			{
			    t9.t=1;
			    t9.paint3();
			    t9.repaint();
			}
		    if(b1.isSelected()==true)
			{
			    t9.t=2;
			    t9.paint3();
			    t9.repaint();
			    // g.drawOval(x,y,(x1-x),(y1-y));
			}
		     if(b3.isSelected()==true)
			 {
			     t9.t=12;
			     t9.paint3();
			     t9.repaint();
			 }
		    if(b2.isSelected()==true)
			{
			    t9.t=3;
			    t9.paint3();
			    t9.repaint();
			    //g.drawRect(x,y,(x1-x),(y1-y));
			}
			 if(b6.isSelected()==true)
			{
			    t9.t=4;
			    t9.paint3();
			    t9.repaint();
			    //   g.fillOval(x,y,(x1-x),(y1-y));
			}
		    if(b7.isSelected()==true)
			{
			    t9.t=5;
			    t9.paint3();
			    t9.repaint(t9.x,t9.y,(t9.x1-t9.x),(t9.y1-t9.y));
			    //  g.fillRect(x,y,(x1-x),(y1-y));
			}
		    if(b14.isSelected()==true)
			{
			    t9.t=16;
			    t9.paint3();
			    t9.repaint();
			}
		}
	    });
	b4.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{
		    t9.cg=JColorChooser.showDialog(new JFrame(),"Choose Color",Color.BLACK);
		    t9.t=10;
		    t9.paint3();
		    t9.repaint();
		}
	    });
	b8.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{
		    Color cg1=JColorChooser.showDialog(new JFrame(),"Choose Color",Color.WHITE);
		    if(cg1!=null)
			{
			    t9.setBackground(cg1);
			    t9.t=6;
			    t9.cg1=cg1;
			    t9.paint3();
			    t9.repaint();
			}
		}
	    });
	b9.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{ 
		    t9.t=7;
		    t9.paint3();
		    t9.repaint();
		    //Graphics g=c.getGraphics();
		    //g.clearRect(40,40,500,360);
		}
		});
	b10.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{
		    //p.show(e.getComponent(),e.getX(),e.getY());
		    p.show(f,200,430);
		}
	    });
	b11.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{
		    t9.t=13;
		    t9.paint3();
		    t9.repaint();
		}
	    });
	b12.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{
		    t9.t=14;
		    t9.paint3();
		    t9.repaint();
		}
	    });
	b15.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{
		    try
			{
			    t9.open2();
			}
		    catch(Exception e1)
			{
			}
		}
	    });
	b13.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{
		    t9.t=15;
		    t9.paint3();
		    t9.repaint();
		}
	    });
	
	f.addMouseListener(new MouseAdapter()
	    {
		public void mouseClicked(MouseEvent e)
		{
		    System.out.println(e.getX()+"            "+e.getY());
		}
	    });
	f.addWindowListener(new WindowAdapter()
	    {
		public void windowClosing(WindowEvent e)
		{
		    if(flag1!=0)
			{
			    f.setVisible(false);
			    f.revalidate();
			    flag1--;
			}
		    else
			if(flag1==0)
			    {
				System.exit(0);
			    }
		}
	    });
		
	//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	f.add(t9);
	f.setJMenuBar(mb);
	j1.add(b5);
	j1.add(b);
	j1.add(b1);
	j1.add(b2);
	j1.add(b3);
       	j1.add(b4);
	//j1.setBackground(new Color(220,170,92));
	//j1.add(b5);
	j1.add(b6);
	j1.add(b7);
	j1.add(b8);
	j1.add(b9);
	j1.add(b10);
	j1.add(b11);
	j1.add(b12);
	j1.add(b13);
	j1.add(b14);
	j1.add(b15);
	j1.setVisible(true);
	f.add(j1);
	f.revalidate();
	//f.setResizable(false);
	f.setSize(WIDTH1,HEIGHT1);
	f.setLayout(null);
	//f.getContentPane().setBackground(new Color(250,170,92));
	//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
    }
    ImageIcon addIcon(String S,int w,int h)
    {
	i=new ImageIcon(S);
	Image i1=i.getImage();
	//Image i2=i1.getScaledInstance(20,30,java.awt.Image.SCALE_SMOOTH ) ;
	Image i2=i1.getScaledInstance(w,h,Image.SCALE_SMOOTH);
	ImageIcon i3=new ImageIcon(i2);
	return i3;
    }
    public static void main(String... Z) throws Exception
    {
	new PaintF("Frame");
    }
}