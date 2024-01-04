using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Al_Mondial
{
    public partial class Staduim : Form
    {
        Controller controller;
        public Staduim()
        {
            InitializeComponent();
            controller = new Controller();  
        }

        private void button6_Click(object sender, EventArgs e)
        {
            int capacity = 0;
            if(textBox1.Text.Length==0)
            {
                MessageBox.Show("Enter A Name");
                return;
            }
            if(textBox2.Text.Length==0)
            {
                MessageBox.Show("Enter A Capacity");
                return;
            }
            try
            {
                capacity = Int32.Parse(textBox2.Text.ToString());
            }
            catch
            {
                MessageBox.Show("Error In Capacity");
                return;
            }
            if(capacity<10000||capacity>90000)
            {
                MessageBox.Show("No such Capacity Provided");

                return;
            }
            int res = controller.InsertStaduim(textBox1.Text, capacity, textBox3.Text);
            if (res == 0)

                MessageBox.Show("Error Occured");
            else
                MessageBox.Show("Inserted Successfully");
            
         







        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
