package test;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SimpleTimeZone;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Test extends JFrame implements ActionListener{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Test t;
	 JButton pintar;
	 JLabel posicion_x;
	 JLabel posicion_y;
	 JLabel Titulo,colortitulo;
	 JButton borrar,zoomas,zoomenos;
	 JButton pintar_alg1;
	 JButton pintar_alg2;
	 JButton pintar_alg3;
	 JButton pintar_alg4;
	 JButton rellenar;
	 static JLabel[][]  matriznumeros;
	 int valor = 10;
	 

	 
	 JFrame ventana;
	 JPanel mainPanel;
	 static JPanel cuadriculaPanel;
	 JTextField areax;
	 JTextField areay;
	 static JTextField areaxa,areaya,areaxb,areayb,areaxc,areayc;
	 JLabel p1,p2,p3;
	 int[] color= new int[3];
	 int count;
	 Border border;
	 Algoritmos alg;
	 JButton c1,c2,c3,c4,c5,c6,c7,c8;
	 
	 
	 
	 
	public Test()
	{
		  count = 1;
		 color[0]=255;
		 color[1]=255;
		 color[2]=255;
		    int n=100;
		
		    border = BorderFactory.createLineBorder(Color.black, 1);
	        ventana = new JFrame("Cuadrícula");
	
	        ventana.setSize(1500,1000);
	        ventana.setResizable(false);
	        ventana.setLayout(null);
	        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        mainPanel = new JPanel();
	        mainPanel.setBounds((1000), 0, (500), 1000);
	        mainPanel.setVisible(true);
	        mainPanel.setLayout(null);
	        mainPanel.setBackground(Color.CYAN);
	        ventana.add(mainPanel);
	        
	        colortitulo = new JLabel("Colores");
	        colortitulo.setBounds(220, 550, 100, 25);
	       
	       
	        mainPanel.add(colortitulo);
	        
	        c1 = new JButton();
	        c1.setBounds(200, 600, 100, 25);
	        c1.setBackground(Color.BLUE);
	        c1.setOpaque(true);
	        c1.addActionListener(this);
	        mainPanel.add(c1);
	        
	        c2 = new JButton();
	        c2.setBounds(200, 625, 100, 25);
	        c2.setBackground(Color.DARK_GRAY);
	        c2.setOpaque(true);
	        c2.addActionListener(this);
	        mainPanel.add(c2);
	        
	        c3 = new JButton();
	        c3.setBounds(200, 650, 100, 25);
	        c3.setBackground(Color.GREEN);
	        c3.setOpaque(true);
	        c3.addActionListener(this);
	        mainPanel.add(c3);
	        
	        c4 = new JButton();
	        c4.setBounds(200, 675, 100, 25);
	        c4.setBackground(Color.magenta);
	        c4.setOpaque(true);
	        c4.addActionListener(this);
	        mainPanel.add(c4);
	        
	        c5 = new JButton();
	        c5.setBounds(200, 700, 100, 25);
	        c5.setBackground(Color.PINK);
	        c5.setOpaque(true);
	        c5.addActionListener(this);
	        mainPanel.add(c5);
	        
	        c6 = new JButton();
	        c6.setBounds(200, 725, 100, 25);
	        c6.setBackground(Color.BLACK);
	        c6.setOpaque(true);
	        c6.addActionListener(this);
	        mainPanel.add(c6);
	        
	        c7 = new JButton();
	        c7.setBounds(200, 750, 100, 25);
	        c7.setBackground(Color.YELLOW);
	        c7.setOpaque(true);
	        c7.addActionListener(this);
	        mainPanel.add(c7);
	        
	        c8 = new JButton();
	        c8.setBounds(200, 775, 100, 25);
	        c8.setBackground(Color.WHITE);
	        c8.setOpaque(true);
	        c8.addActionListener(this);
	        mainPanel.add(c8);
	        
	        
	        
	        cuadriculaPanel = new JPanel();
	        
	        cuadriculaPanel.setBounds(0, 0, 1000, 1000);
	        cuadriculaPanel.setVisible(true);
	        cuadriculaPanel.setLayout(null);
	        
	        ventana.add(cuadriculaPanel);
	        
	     
	 //       border = BorderFactory.createLineBorder(Color.black, 1);
	        
	        Titulo = new JLabel();
	        Titulo.setBounds(200, 0,100, 25);
	        Titulo.setText("MINI_PAINT");
	        //Titulo.
	        mainPanel.add(Titulo);
	        
	        posicion_x = new JLabel("Poscicion 1");
	        posicion_x.setBounds(0,500, 100, 25);
	        posicion_x.setText("Posición x:");
	        mainPanel.add(posicion_x);
	        
	        posicion_y = new JLabel("Poscicion 1");
	        posicion_y.setBounds(0,550, 100, 25);
	        posicion_y.setText("Posición y:");
	        mainPanel.add(posicion_y);
	        
	        
	        pintar = new JButton();
	        pintar.setText("Pintar");
	        pintar.setBounds(180, 200, 100, 25);
	        pintar.addActionListener(this);
	        mainPanel.add(pintar);
	        
	        borrar = new JButton();
	        borrar.setText("Borrar todo");
	        borrar.setBounds(300, 200, 100, 25);
	        borrar.addActionListener(this);
	        mainPanel.add(borrar);
	        
	        zoomas = new JButton();
	        zoomas.setText("zoom +");
	        zoomas.setBounds(300, 300, 100, 25);
	        zoomas.addActionListener(this);
	        mainPanel.add(zoomas);
	        
	        
	        zoomenos = new JButton();
	        zoomenos.setText("zoom -");
	        zoomenos.setBounds(300, 400, 100, 25);
	        zoomenos.addActionListener(this);
	        mainPanel.add(zoomenos);
	       
	        	        
	        pintar_alg1 = new JButton();
	        pintar_alg1.setText("Algoritmo DDA");
	        pintar_alg1.setBounds(0, 200, 150, 25);
	        pintar_alg1.addActionListener(this);
	        mainPanel.add(pintar_alg1);
	        
	        pintar_alg2 = new JButton();
	        pintar_alg2.setText("Algoritmo Bresenham");
	        pintar_alg2.setBounds(0, 280, 200, 25);
	        pintar_alg2.addActionListener(this);
	        mainPanel.add(pintar_alg2);
	        
	        pintar_alg3 = new JButton();
	        pintar_alg3.setText("Algoritmo circulo");
	        pintar_alg3.setBounds(0, 350, 200, 25);
	        pintar_alg3.addActionListener(this);
	        mainPanel.add(pintar_alg3);
	        
	        pintar_alg4 = new JButton();
	        pintar_alg4.setText("Algoritmo midpoint");
	        pintar_alg4.setBounds(0, 420, 200, 25);
	        pintar_alg4.addActionListener(this);
	        mainPanel.add(pintar_alg4);
	        
	        rellenar = new JButton();
	        rellenar.setText("rellenar");
	        rellenar.setBounds(0, 480, 200, 25);
	        rellenar.addActionListener(this);
	        mainPanel.add(rellenar);
	        
	        areax = new JTextField();
	        areax.setText("0");
	        areax.setBounds(100, 500, 50, 25);
	        mainPanel.add(areax);

	        areay = new JTextField();
	        areay.setText("0");
	        areay.setBounds(100, 550, 50, 25);
	        mainPanel.add(areay);
	        
	        p1 = new JLabel();
	        p1.setBounds(220,270, 100, 25);
	        p1.setText("PUNTO 1");
	        mainPanel.add(p1);
	        
	        areaxa = new JTextField();
	        areaxa.setText("0");
	        areaxa.setBounds(200, 300, 25, 25);
	        mainPanel.add(areaxa);
	        
	        areaya = new JTextField();
	        areaya.setText("0");
	        areaya.setBounds(250, 300, 25, 25);
	        mainPanel.add(areaya);
	        
	        p2 = new JLabel();
	        p2.setBounds(220,370, 100, 25);
	        p2.setText("PUNTO 2");
	        mainPanel.add(p2);
	        
	        areaxb = new JTextField();
	        areaxb.setText("0");
	        areaxb.setBounds(200, 400, 25, 25);
	        mainPanel.add(areaxb);
	        
	        areayb = new JTextField();
	        areayb.setText("0");
	        areayb.setBounds(250, 400, 25, 25);
	        mainPanel.add(areayb);
	        
	        p3 = new JLabel();
	        p3.setBounds(220,450, 100, 25);
	        p3.setText("PUNTO 3");
	        mainPanel.add(p3);
	        
	        areaxc = new JTextField();
	        areaxc.setText("0");
	        areaxc.setBounds(200, 500, 25, 25);
	        mainPanel.add(areaxc);
	        
	        areayc = new JTextField();
	        areayc.setText("0");
	        areayc.setBounds(250, 500, 25, 25);
	        mainPanel.add(areayc);
	              


            matriznumeros = new JLabel[n][n];
            
            for(int x=0;x<matriznumeros.length;x++)
            {
            	for(int y=0;y<matriznumeros.length;y++)
            	{
            		matriznumeros[x][y]= new JLabel();
            		
            	}
            }
          formar_cuadricula_base(10);
           
           for(int a=0;a<matriznumeros.length;a++)
           {
        	   for(int b=0;b<matriznumeros.length;b++)
        	   {
        		   matriznumeros[a][b].addMouseListener(new MouseAdapter(){
        			@Override  
        			public void mouseClicked( MouseEvent ev) 
        			{
        				 for(int a1=0;a1<matriznumeros.length;a1++)
        		           {
        		        	   for(int b1=0;b1<matriznumeros.length;b1++)
        		        	   {
        		        	     if(matriznumeros[a1][b1]==ev.getSource())
        		        	     {
        		        	    	 Algoritmos.posiciones(a1, b1);
        		        	    	 System.out.println("posicion x "+b1+" y "+a1);
        		        	     }
        		        	   }
        		           }
        			}
        		   });
        	   }
           }
          
	      
	      
        
          ventana.setVisible(true);
  	      


        
	}
	 public void actionPerformed(ActionEvent e) {
		
	        if (e.getSource()==borrar) {
	        	
	        	cuadriculaPanel.removeAll();
	        	cuadriculaPanel.revalidate();
	        	cuadriculaPanel.repaint();

	               for(int x=0;x<matriznumeros.length;x++)
		            {
		             	for(int y=0;y<matriznumeros.length;y++)
		             	{
		             		
		             		
		             		matriznumeros[x][y].setBounds(x*valor, y*valor, valor,valor);
		             		cuadriculaPanel.add(matriznumeros[x][y],0);
		             		
		             	}
		             }
	        	
	        	 
	        }
	        if(e.getSource()==zoomas)
	        {
	        	cuadriculaPanel.removeAll();
	        	cuadriculaPanel.revalidate();
	        	cuadriculaPanel.repaint();
	        	valor += 5;
	        	
               for(int x=0;x<matriznumeros.length;x++)
	            {
	             	for(int y=0;y<matriznumeros.length;y++)
	             	{
	             		
	             		
	             		matriznumeros[x][y].setBounds(x*valor, y*valor, valor,valor);
	             		cuadriculaPanel.add(matriznumeros[x][y],0);
	             		
	             	}
	             }
	        }
	        if(e.getSource()==zoomenos)
	        {
	        	valor -= 5;
	        	cuadriculaPanel.removeAll();
	        	cuadriculaPanel.revalidate();
	        	cuadriculaPanel.repaint();
	        	formar_cuadricula_base(valor);
	        }
	        if(e.getSource()==pintar)
	        {
	        	 matriznumeros[Integer.parseInt((areax.getText()))][Integer.parseInt((areay.getText()))].setBackground(Color.GREEN);
	        	 System.out.println("asd");
	        }
	        if(e.getSource()==pintar_alg1)
	        {
	        	Algoritmos.crear_algoritmo_1(Integer.parseInt((areaxa.getText())), Integer.parseInt((areaya.getText())), Integer.parseInt((areaxb.getText())), Integer.parseInt((areayb.getText())),color);
	        }
	        if(e.getSource()==pintar_alg2)
	        {
	        	Algoritmos.algoritmobresenham(Integer.parseInt((areaxa.getText())), Integer.parseInt((areaya.getText())), Integer.parseInt((areaxb.getText())), Integer.parseInt((areayb.getText())),color);
	        }
	        if(e.getSource()==pintar_alg3)
	        {
	        	 double respuest;
	             double res1,res2;
              int x1=Integer.parseInt((areaxa.getText()));
              int y1=Integer.parseInt((areaya.getText()));
              int x2= Integer.parseInt((areaxb.getText()));
              int y2= Integer.parseInt((areayb.getText()));
	             res1=x2-x1;   res2=y2-y1;
	             res1=Math.pow(res1, 2)+Math.pow(res2, 2);
	             respuest=(int)Math.sqrt(res1);
	             System.out.println(respuest);
	              Algoritmos.pintarcirculo(x1, y1, (int)respuest,color);
	        }
	        if(e.getSource()==pintar_alg4)
	        {
	        	int rx,ry;
	             double res1,res2;
	        	int x1=Integer.parseInt((areaxa.getText()));
	              int y1=Integer.parseInt((areaya.getText()));
	              int x2= Integer.parseInt((areaxb.getText()));
	              int y2= Integer.parseInt((areayb.getText()));
		             res1=x2-x1;   res2=y2-y1;
		             res1=Math.pow(res1, 2)+Math.pow(res2, 2);
		             rx=(int)Math.sqrt(res1);
		              x1=Integer.parseInt((areaxa.getText()));
		              y1=Integer.parseInt((areaya.getText()));
		              x2= Integer.parseInt((areaxc.getText()));
		               y2= Integer.parseInt((areayc.getText()));
			             res1=x2-x1;   res2=y2-y1;
			             res1=Math.pow(res1, 2)+Math.pow(res2, 2);
			             ry=(int)Math.sqrt(res1);
			             System.out.println("x"+rx+" y"+ry);
			             Algoritmos.ellipseMidpoint(x1, y1, rx, ry,color);
		            
	        }
	        if(e.getSource()==c1)
	        {
	        	color[0] =6;
	        	color[1]=57;
	        	color[2]=113;
	        }
	        if(e.getSource()==c2)
	        {
	        	color[0] =76;
	        	color[1]=81;
	        	color[2]=074;
	        }
	        if(e.getSource()==c3)
	        {
	        	color[0] =124;
	        	color[1]=252;
	        	color[2]=0;
	        }
	        if(e.getSource()==c4)
	        {
	        	color[0] =255;
	        	color[1]=58;
	        	color[2]=255;
	        }
	        if(e.getSource()==c5)
	        {
	        	color[0] =255;
	        	color[1]=192;
	        	color[2]=203;
	        }
	        if(e.getSource()==c6)
	        {
	        	color[0] =0;
	        	color[1]=0;
	        	color[2]=0;
	        }
	        if(e.getSource()==c7)
	        {
	        	color[0] =255;
	        	color[1]=255;
	        	color[2]=0;
	        }
	        if(e.getSource()==c8)
	        {
	        	color[0] =255;
	        	color[1]=255;
	        	color[2]=255;
	        }
	        if(e.getSource()==rellenar)
	        {
	        	Algoritmos.fill(Integer.parseInt((areaxa.getText())),Integer.parseInt((areaya.getText())) ,color, color);
	        }
	        
	    }
	 
	 public void formar_cuadricula_base(int volumen)
	 {
		 int asd= 20;
		 for(int x=0;x<matriznumeros.length;x++)
         {
         	for(int y=0;y<matriznumeros.length;y++)
         	{
         		
         		matriznumeros[x][y].setBackground(Color.WHITE);
         		matriznumeros[x][y].setBorder(border);
         		matriznumeros[x][y].setOpaque(true);
         		matriznumeros[x][y].setVisible(true);
         		matriznumeros[x][y].setBounds(x*volumen, y*volumen, volumen, volumen);
         		cuadriculaPanel.add(matriznumeros[x][y],0);
         		
         	}
         }
	 }/*
	 public void crear_algoritmo_1(int xa,int ya,int xb,int yb)
	 {
		 int dx = xb-xa;
		 int dy = yb-ya;
		 int steps,k;
		 float xincrement,yincrement,x,y;
		 x =xa;
		 y = ya;
		 
		 if(Math.abs(dx)> Math.abs(dy))
		 {
			 steps = Math.abs(dx);
		 }
		 else
		 {
			 steps= Math.abs(dy);
		 }
		 xincrement = dx/((float)steps);
		 yincrement = dy/((float)steps);
		  matriznumeros[Math.round(x)][Math.round(y)].setBackground(Color.BLUE);
		 for(k=0;k<steps;k++)
		 {
			 x += xincrement;
			 y += yincrement;
			 matriznumeros[Math.round(x)][Math.round(y)].setBackground(Color.BLUE);
		 }
	 }
	 
	 public void algoritmobresenham(int xa,int ya,int xb, int yb)
	 {
		 int dx = Math.abs(xa-xb);
		 int dy = Math.abs(ya-yb);
		 int p = 2*dy-dx;
		 int twoDY = 2*dy;
		 int twoDYDX = 2*(dy-dx);
		 int x,y,xend;
		 if(xa>xb)
		 {
			x=xb; 
			y=yb;
			xend=xa;
			
		 }
		 else 
		 {
			 x=xa;
			 y=ya;
			 xend=xb;
		 }
		 matriznumeros[Math.round(x)][Math.round(y)].setBackground(Color.BLUE);
		 
		 while(x<xend)
		 {
			 x++;
			 if(p<0)
			 {
				 p += twoDY;
			 }
			 else
			 {
				 y++;
				 p += twoDYDX;
			 }
			 matriznumeros[Math.round(x)][Math.round(y)].setBackground(Color.BLUE);
		 }
	 }
	 public void posiciones(int x,int y)
	 {
		 
		 
		 if(count==1)
		 {
			 areaxa.setText(""+x);
			 areaya.setText(""+y);
			 count=2;
		 }
		 else 
		 {
			 areaxb.setText(""+x);
			 areayb.setText(""+y);
			 count=1;
			 System.out.println("dadsasd");
		 }
		 
		
		  
		 
	 }*/
    public static void main(String[] args){
    
         new Test();
    
    }  
}