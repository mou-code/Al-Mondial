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
    public partial class ALMondial_System : Form
    {
        public ALMondial_System(string username,int type)
        {
            InitializeComponent();
            this.AdminLabel.Text = username;
            if (type == 1 || type == 2)
            {
                button12.Enabled = false;
            }
            else
                button12.Enabled = true;
        }

        public void loadform(object Form)
        {
            if (this.panel4.Controls.Count > 0)
                this.panel4.Controls.RemoveAt(0);
            Form f = Form as Form;
            f.TopLevel = false;
            f.Dock = DockStyle.Fill;
            this.panel4.Controls.Add(f);
            this.panel4.Tag = f;
            f.Show();
        }
        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            
        }

        private void AdminNameLabel_TextChanged(object sender, EventArgs e)
        {

        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            loadform(new Match());

        }

        private void button5_Click(object sender, EventArgs e)
        {
            loadform(new Ticket());


        }

        private void CloseButton_Click(object sender, EventArgs e)
        {
            this.Hide();
            this.Close();
        }

        private void AdminLabel_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            loadform(new News());

        }

        private void button7_Click(object sender, EventArgs e)
        {
            loadform(new Player());

        }

        private void button8_Click(object sender, EventArgs e)
        {
            loadform(new Goal());

        }

        private void button6_Click(object sender, EventArgs e)
        {
            loadform(new Staduim());


        }

        private void button9_Click(object sender, EventArgs e)
        {
            Refree refre= new Refree();
            refre.Show();
            this.Hide();




        }

        private void button3_Click(object sender, EventArgs e)
        {
            loadform(new Groups());

        }

        private void button10_Click(object sender, EventArgs e)
        {
            loadform(new Team());

        }

        private void button11_Click(object sender, EventArgs e)
        {
            Coach c = new Coach();
            c.Show();
        }

        private void button12_Click(object sender, EventArgs e)
        {
            loadform(new MakeAdmin(AdminLabel.Text));

        }

        private void button13_Click(object sender, EventArgs e)
        {
            sponser s = new sponser();
            s.Show();
        }

        private void button14_Click(object sender, EventArgs e)
        {
            Groups g = new Groups();
            g.Show();
        }

        private void panel4_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            loadform(new Refree());

        }

        private void button11_Click_1(object sender, EventArgs e)
        {
            loadform(new sponser());

        }

        private void button9_Click_1(object sender, EventArgs e)
        {
            loadform(new Coach());

        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void panel3_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button13_Click_1(object sender, EventArgs e)
        {
            loadform(new CleenSheetcs());
        }
    }
}
