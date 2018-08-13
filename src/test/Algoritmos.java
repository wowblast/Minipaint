package test;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Algoritmos {

	static Border  border;
	static ArrayList<Integer> Puntos ;
	static int count=1;
	public Algoritmos()
	{
		border = BorderFactory.createLineBorder(Color.black, 1);
		Puntos = new ArrayList<Integer>();
		System.out.println(Test.matriznumeros[0][0].getBackground()+"swdaw");


	}


	public static void crear_algoritmo_1(int xa,int ya,int xb,int yb,int[]color)
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
		Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));
		for(k=0;k<steps;k++)
		{
			x += xincrement;
			y += yincrement;
			Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));
		}
	}

	public static void algoritmobresenham(int xa,int ya,int xb, int yb,int[] color)
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
		Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));


		int m = (yb-ya)/(xb-xa);
		while(x<xend)
		{
			x++;
			if(p<0)
			{
				p += twoDY;
			}
			else
			{
				if(m<0)
				{
					y--;
				}
				else
				{
					y++;
					p += twoDYDX; 
				}

			}
			Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(new Color(color[0],color[1],color[2]));

			//Test.matriznumeros[Math.round(x)][Math.round(y)].setBackground(Color.BLUE);
		}
	}
	public static void posiciones(int x,int y)
	{


		if(count==1)
		{
			Test.areaxa.setText(""+x);
			Test.areaya.setText(""+y);
			count=2;
		}
		else if (count==2)
		{
			Test.areaxb.setText(""+x);
			Test.areayb.setText(""+y);
			count=3;
		}
		else 
		{
			Test.areaxc.setText(""+x);
			Test.areayc.setText(""+y);
			count=1;
			System.out.println("dadsasd");
		}




	}
	public static void pintarcirculo(int xcenter,int ycenter,int radius,int[]color)
	{
		int x=0;
		int y= radius;
		int p = 1-radius;
		pintarcirpuntos(xcenter, ycenter, x,y,color);

		while(x<y)
		{
			x++;
			if(p<0)
			{
				p +=2*(x)+1;
			}
			else
			{
				y--;
				p +=2*(x-y)+1;
			}
			pintarcirpuntos(xcenter, ycenter, x, y,color);
		}
	}
	public static void pintarcirpuntos(int xcenter,int ycenter, int x, int y,int[]color)
	{
		Test.matriznumeros[xcenter+x][ycenter+y].setBackground(new Color(color[0],color[1],color[2]));
		Test.matriznumeros[xcenter-x][ycenter+y].setBackground(new Color(color[0],color[1],color[2]));
		Test.matriznumeros[xcenter+x][ycenter-y].setBackground(new Color(color[0],color[1],color[2]));
		Test.matriznumeros[xcenter-x][ycenter-y].setBackground(new Color(color[0],color[1],color[2]));
		Test.matriznumeros[xcenter+y][ycenter+x].setBackground(new Color(color[0],color[1],color[2]));
		Test.matriznumeros[xcenter-y][ycenter+x].setBackground(new Color(color[0],color[1],color[2]));
		Test.matriznumeros[xcenter+y][ycenter-x].setBackground(new Color(color[0],color[1],color[2]));
		Test.matriznumeros[xcenter-y][ycenter-x].setBackground(new Color(color[0],color[1],color[2]));


	}
	public static void ellipseMidpoint (int xCenter, int yCenter, int Rx, int Ry,int[]color)
	{
		int Rx2 = Rx*Rx;
		int Ry2 = Ry*Ry;
		int twoRx2 = 2*Rx2;
		int twoRy2 = 2*Ry2;
		int p;
		int x = 0;
		int y = Ry;
		int px = 0;
		int py = twoRx2*y;

		ellipsePlotPoints (xCenter, yCenter, x, y,color);

		p = (int) Math.round (Ry2 - (Rx2*Ry) + (0.25*Rx2));
		while (px < py) {
			x++;
			px += twoRy2;
			if (p < 0){
				p += Ry2 + px;
			}
			else {
				y--;
				py -= twoRx2;
				p += Ry2 + px - py;

				//
			}
			ellipsePlotPoints (xCenter, yCenter, x, y,color);
			/* Region 2 */
			p = (int) Math.round (Ry2*(x+0.5)*(x+0.5) + Rx2*(y-1)*(y-1) - Rx2*Ry2);
			while (y > 0) 
			{
				y--;
				py -= twoRx2;
				if (p > 0)
				{
					p += Rx2 - py;
				}
				else {
					x++;
					px += twoRy2;
					p += Rx2 - py + px; 
				}
				ellipsePlotPoints (xCenter, yCenter, x, y,color);
			}
		}

	}

	public static void ellipsePlotPoints (int xCenter, int yCenter, int x, int y,int[]color){




		Test.matriznumeros[xCenter+x][yCenter+y].setBackground(Color.BLUE);
		Test.matriznumeros[xCenter-x][yCenter+y].setBackground(Color.BLUE);
		Test.matriznumeros[xCenter+x][yCenter-y].setBackground(Color.BLUE);
		Test.matriznumeros[xCenter-x][yCenter-y].setBackground(Color.BLUE);

	}
	public static void fill(int x, int y, int[]fill,int[]boundary)
	{
		int [] current = new int[3];
		current[0]=Test.matriznumeros[x][y].getBackground().getRed();
		current[1]=Test.matriznumeros[x][y].getBackground().getGreen();
		current[2]=Test.matriznumeros[x][y].getBackground().getBlue();
		// reads the pixel value of pixel at x,y

		// if pixel is neither boundary color nor fill color
		// then fills the color
		if (boundary[0]!=current[0]&&boundary[1]!=current[0]&&boundary[2]!=current[0]&&255==current[0]&&255==current[0]&&255==current[0]) {
			
			
			Test.matriznumeros[x][y].setBackground( new Color(fill[0], fill[1], fill[2]) );
			
			// recursive call
			fill(x + 1, y, fill, boundary);
			fill(x - 1, y, fill, boundary);
			fill(x, y + 1,fill, boundary);
			fill(x, y - 1, fill, boundary);
		}
		
	}
}
