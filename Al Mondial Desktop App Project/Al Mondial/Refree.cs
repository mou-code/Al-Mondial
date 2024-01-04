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
    public partial class Refree : Form
    {
        Controller controller;
        public Refree()
        {
            InitializeComponent();
            controller = new Controller();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Length == 0)
            {
                MessageBox.Show("Inter Id");
                return;
            }
            int id = Int32.Parse(textBox1.Text.ToString());



            if(textBox2.Text.Length == 0)
            {
                MessageBox.Show("Inter a Name");
                return;
            }
            int res = controller.InsertRefree(id, textBox2.Text);
            if (res == 0)
                MessageBox.Show("Error occured");
            else
                MessageBox.Show("Inserted Successfully");
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }
    }
}
