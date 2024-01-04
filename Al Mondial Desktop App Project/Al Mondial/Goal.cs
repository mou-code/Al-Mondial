using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Al_Mondial
{

    public partial class Goal : Form
    {
        Controller controller;
        public Goal()
        {
            InitializeComponent();
            controller = new Controller();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            if(textBox3.Text.Length==0)
            {
                MessageBox.Show("Please Enter A PLayer_id");
                return;            
            }
            int Player_id = Int32.Parse(textBox3.Text);
            if (textBox2.Text.Length == 0)
            {
                MessageBox.Show("Please Enter A Match_id");
                return;
            }
            int Match_id = Int32.Parse(textBox2.Text);
            if (textBox1.Text.Length == 0)
            {
                MessageBox.Show("Please Enter A Min");
                return;
            }
            int Min = Int32.Parse(textBox1.Text);
            if(Min>95||Min<=0)
            {
                MessageBox.Show("Invalid Min");
                return;
            }
            int res = controller.InsertGoal(Player_id, Match_id, Min);
            if (res == 0)
            
                MessageBox.Show("Error Occured");
     
            else
                MessageBox.Show("Inserted Successfully");



        }
    }
}
